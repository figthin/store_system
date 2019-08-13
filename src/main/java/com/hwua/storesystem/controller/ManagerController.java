package com.hwua.storesystem.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.storesystem.entity.*;
import com.hwua.storesystem.service.*;
import com.hwua.storesystem.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ManagerRoleService managerRoleService;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping(value = "/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result login(HttpSession session, String name, String password){
        Manager manager = managerService.login(name, password);
        List<Role> roles = manager.getRoles();
        List<Integer> roleIds = new ArrayList<>();
        for (Role role : roles) {
            roleIds.add(role.getRoleId());
        }
        List<Permission> permissions = permissionService.listByRoleIds(roleIds);
        session.setAttribute("permissions",permissions);
        session.setAttribute("manager",manager);
        return new Result("登录成功");
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model){
        List<Map<String, Object>> announcements = announcementService.list();
        List<Map<String, Object>> comments = commentService.list();
        List<Product> products = productService.list();
        List<User> users = userService.list();
        List<Manager> managers = managerService.list();
        model.addAttribute("announcements",announcements);
        model.addAttribute("comments",comments);
        model.addAttribute("products",products);
        model.addAttribute("users",users);
        model.addAttribute("managers",managers);
        return "index";
    }

    @GetMapping("/admin-list")
    public String adminList(HttpServletRequest request){
        List<Manager> managers = managerService.list();
        request.setAttribute("managers",managers);
        return "admin-list";
    }

    @GetMapping("/admin-add")
    public String adminAddForm(Model model,Integer managerId){
        if (managerId != null){
            Manager manager = managerService.getById(managerId);
            model.addAttribute("manager",manager);
        }
        List<Role> roles = roleService.list();
        model.addAttribute("roles",roles);
        return "admin-add";
    }


    @PostMapping(value = "/admin-add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminAdd(Manager manager, Integer roleId){
        Boolean add = managerService.insertOrUpdate(manager);
        Integer managerId = manager.getManagerId();
        Boolean add1 = managerRoleService.add(managerId, roleId);
        Boolean b = add && add1;
        Map<String,Object> json = new HashMap<>();
        json.put("result",b);
        return JSON.toJSONString(json);
    }

    @DeleteMapping(value = "admin-del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminDel(Integer managerId){
        Boolean sub = managerService.sub(managerId);
        Map<String, Object> json = new HashMap<>();
        json.put("result",sub);
        return JSON.toJSONString(json);
    }

    @PutMapping(value = "admin_start",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminStart(String operate,Integer managerId){
        Boolean aBoolean = managerService.alterStatus(operate, managerId);
        Map<String,Object> json = new HashMap<>();
        json.put("result",aBoolean);
        return JSON.toJSONString(json);
    }

    @PutMapping(value = "admin_stop",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminStop(String operate,Integer managerId){
        Boolean aBoolean = managerService.alterStatus(operate, managerId);
        Map<String,Object> json = new HashMap<>();
        json.put("result",aBoolean);
        return JSON.toJSONString(json);
    }
}

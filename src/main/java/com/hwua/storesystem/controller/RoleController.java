package com.hwua.storesystem.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.storesystem.entity.Role;
import com.hwua.storesystem.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @GetMapping("/admin-role")
    public String adminRole(Model model){
        List<Role> roles = roleService.list();
        model.addAttribute("roles",roles);
        return "admin-role";
    }

    @GetMapping("/admin-role-add")
    public String adminRoleAddForm(Model model, Integer roleId){
        if (roleId != null){
            Role role = roleService.getByRoleId(roleId);
            model.addAttribute("role",role);
        }
        return "admin-role-add";
    }

    @PostMapping(value = "/admin-role-add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminRoleAdd(Integer roleId, String roleName, String description){
        Boolean update;
        if (roleId != null){
            update = roleService.alter(roleId, roleName, description);
        }else {
            update = roleService.add(roleName, description);
        }
        Map<String,Object> json = new HashMap<>();
        json.put("result",update);
        return JSON.toJSONString(json);
    }

    @PostMapping(value = "/admin-role-del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminRoleDel(Integer roleId){
        Boolean sub = roleService.sub(roleId);
        Map<String,Object> json = new HashMap<>();
        json.put("result",sub);
        return JSON.toJSONString(json);
    }
}

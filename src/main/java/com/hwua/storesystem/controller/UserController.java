package com.hwua.storesystem.controller;

import com.alibaba.fastjson.JSON;
import com.hwua.storesystem.entity.User;
import com.hwua.storesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/member-list")
    public String memberList(Model model){
        List<User> users = userService.list();
        model.addAttribute("users",users);
        return "member-list";
    }

    @GetMapping("/member-show")
    public String memberShow(Integer userId, Model model){
        User user = userService.getById(userId);
        model.addAttribute("user",user);
        return "member-show";
    }

    @GetMapping("/change-password")
    public String changePasswordForm(Integer userId, Model model){
        User user = userService.getById(userId);
        model.addAttribute("user",user);
        return "change-password";
    }

    @PutMapping(value = "/change-password",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changePassword(Integer userId, String password){
        Boolean aBoolean = userService.changePassword(userId, password);
        Map<String,Object> json = new HashMap<>();
        json.put("result",aBoolean);
        return JSON.toJSONString(json);
    }

    @GetMapping("/member-add")
    public String memberAddForm(Integer userId, Model model){
        if (userId != null){
            User user = userService.getById(userId);
            model.addAttribute("user",user);
        }
        return "member-add";
    }

    @PostMapping(value = "/member-add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String memberAdd(User user){
        Boolean aBoolean = userService.insertOrUpdate(user);
        Map<String, Object> json = new HashMap<>();
        json.put("result",aBoolean);
        return JSON.toJSONString(json);
    }

    @PostMapping(value = "/member-start",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminStart(String operate,Integer userId){
        Boolean aBoolean = userService.alterStatus(operate, userId);
        Map<String,Object> json = new HashMap<>();
        json.put("result",aBoolean);
        return JSON.toJSONString(json);
    }

    @PostMapping(value = "/member-stop",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String adminStop(String operate,Integer userId){
        Boolean aBoolean = userService.alterStatus(operate, userId);
        Map<String,Object> json = new HashMap<>();
        json.put("result",aBoolean);
        return JSON.toJSONString(json);
    }

    @PostMapping(value = "/member-del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String memberDel(Integer userId){
        Boolean delete = userService.delete(userId);
        Map<String, Object> json = new HashMap<>();
        json.put("result",delete);
        return JSON.toJSONString(json);
    }

    @GetMapping("/member-del")
    public String memberDel(Model model){
        List<User> users = userService.getUserDel();
        model.addAttribute("users",users);
        return "member-del";
    }

    @PostMapping(value = "/member_return",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String memberReturn(Integer userId){
        Boolean aBoolean = userService.alterStatus("启用", userId);
        Map<String,Object> json = new HashMap<>();
        json.put("result",aBoolean);
        return JSON.toJSONString(json);
    }
}

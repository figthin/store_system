package com.hwua.storesystem.controller;


import com.hwua.storesystem.entity.Permission;
import com.hwua.storesystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @GetMapping("/admin-permission")
    public String adminPermission(Model model){
        List<Permission> permissions = permissionService.list();
        model.addAttribute("permissions",permissions);
        return "admin-permission";
    }
}

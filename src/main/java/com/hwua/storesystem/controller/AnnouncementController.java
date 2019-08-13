package com.hwua.storesystem.controller;

import com.hwua.storesystem.entity.Announcement;
import com.hwua.storesystem.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("/announcement-list")
    public String announcementList(Model model){
        List<Map<String, Object>> announcements = announcementService.list();
        model.addAttribute("announcements",announcements);
        return "announcement-list";
    }

}

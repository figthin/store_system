package com.hwua.storesystem.controller;

import com.hwua.storesystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment-list")
    public String commentList(Model model){
        List<Map<String, Object>> comments = commentService.list();
        model.addAttribute("comments",comments);
        return "comment-list";
    }
}

package com.sts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
    @GetMapping("/user")
    public String getUser(Model model) {
        model.addAttribute("something", "welcome to the club");
        return "user";
    }
}
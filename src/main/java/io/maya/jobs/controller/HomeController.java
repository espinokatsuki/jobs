package io.maya.jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/")
    public String ShowHome(Model model) {
        model.addAttribute("message", "Welcome to Jobs App!");
        model.addAttribute("date", new Date());
        return "home";
    }
}

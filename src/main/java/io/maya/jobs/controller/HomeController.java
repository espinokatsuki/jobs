package io.maya.jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(Model model) {
        String name = "Frontend developer";
        Date publicationDate = new Date();
        Double salary = 5000.0;
        Boolean active = Boolean.TRUE;

        model.addAttribute("name", name);
        model.addAttribute("publicationDate", publicationDate);
        model.addAttribute("salary", salary);
        model.addAttribute("active", active);

        return "home";
    }
}

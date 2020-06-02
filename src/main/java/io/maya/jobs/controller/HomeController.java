package io.maya.jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/list")
    public String showList(Model model) {
        List<String> jobs = new LinkedList<>();
        jobs.add("Software Engineer");
        jobs.add("Back-end developer");
        model.addAttribute("jobs", jobs);
        return "list";
    }

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

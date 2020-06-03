package io.maya.jobs.controller;

import io.maya.jobs.model.Vacant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/detail")
    public String getDetail(Model model) {
        Vacant vacant = new Vacant();
        vacant.setName("SCRUM Master");
        vacant.setDescription("Coordinate software areas");
        vacant.setSalary(1000.0);
        vacant.setActive(Boolean.TRUE);
        model.addAttribute("vacant", vacant);
        return "detail";
    }

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

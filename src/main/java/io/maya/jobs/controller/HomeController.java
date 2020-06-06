package io.maya.jobs.controller;

import io.maya.jobs.model.Vacant;
import io.maya.jobs.service.IVacantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private IVacantService vacantService;

    @GetMapping("/")
    public String showHome(Model model) {
        List<Vacant> vacantList = vacantService.getAll();
        model.addAttribute("vacantList", vacantList);
        return "/home";
    }

}

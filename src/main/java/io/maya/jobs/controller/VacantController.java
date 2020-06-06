package io.maya.jobs.controller;

import io.maya.jobs.model.Vacant;
import io.maya.jobs.service.IVacantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vacants")
public class VacantController {

    private final Logger logger = LoggerFactory.getLogger(VacantController.class);

    @Autowired
    private IVacantService vacantService;

    @GetMapping("/view/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        Vacant vacant = vacantService.getById(id);
        model.addAttribute("vacant", vacant);
        logger.info("Vacant {} called: {}", id, vacant);
        return "vacant/detail";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") int id, Model model) {
        List<Vacant> vacantList = vacantService.getAll();
        for (Vacant vacant :
                vacantList) {
            if (vacant.getId() == id) {
                model.addAttribute("id", id);
                logger.info("Vacant {} deleted: {}", id, vacant);
                vacantList.remove(vacant);
                break;
            }
        }
        return "vacant/delete";
    }

    @GetMapping("/create")
    public String create() {
        return "vacant/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("description") String description,
                       @RequestParam("status") Integer status, @RequestParam("publicationDate") String publicationDate,
                       @RequestParam("highlighted") Integer highlighted, @RequestParam("salary") Double salary,
                       @RequestParam("details") String details) {
        System.out.println(name);
        System.out.println(description);
        System.out.println(status);
        System.out.println(publicationDate);
        System.out.println(highlighted);
        System.out.println(salary);
        System.out.println(details);
        return "vacant/added";
    }

}

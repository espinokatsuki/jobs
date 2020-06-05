package io.maya.jobs.controller;

import io.maya.jobs.model.Vacant;
import io.maya.jobs.service.IVacantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacants")
public class VacantController {

    private final Logger logger = LoggerFactory.getLogger(VacantController.class);

    @Autowired
    private IVacantService vacantService;

    @GetMapping("")
    public String listAll(Model model) {
        List<Vacant> vacantList = vacantService.getAll();
        model.addAttribute("vacantList", vacantList);
        return "vacant/index";
    }

    @GetMapping("/view/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        // TODO: Search vacant in DDBB
        List<Vacant> vacantList = vacantService.getAll();
        model.addAttribute("vacant", vacantList.get(id - 1));
        logger.info("Vacant {} called: {}", id, vacantList.get(id - 1));
        return "vacant/detail";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") int id, Model model) {
        // TODO: Delete vacant in DDBB
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
    public String save(@RequestParam("id") int id, @RequestParam("name") String name,
                       @RequestParam("description") String description, @RequestParam("salary") double salary,
                       Model model) {
        List<Vacant> vacantList = vacantService.getAll();
        Vacant vacant = new Vacant();
        vacant.setId(id);
        vacant.setName(name);
        vacant.setDescription(description);
        vacant.setSalary(salary);
        vacant.setPublicationDate(new Date());
        vacantList.add(vacant);
        logger.info("Vacant added: {}", vacant);
        model.addAttribute("name", name);
        return "vacant/added";
    }

}

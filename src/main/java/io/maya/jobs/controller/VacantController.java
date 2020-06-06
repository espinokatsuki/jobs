package io.maya.jobs.controller;

import io.maya.jobs.model.Vacant;
import io.maya.jobs.service.IVacantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacants")
public class VacantController {

    private final Logger logger = LoggerFactory.getLogger(VacantController.class);

    @Autowired
    private IVacantService vacantService;

    @GetMapping("/index")
    public String listAllVacants(Model model) {
        List<Vacant> vacantList = vacantService.getAll();
        model.addAttribute("vacantList", vacantList);
        return "vacant/index";
    }

    @GetMapping("/view/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        Vacant vacant = vacantService.getById(id);
        model.addAttribute("vacant", vacant);
        logger.info("Vacant {} called: {}", id, vacant);
        return "vacant/detail";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") int id) {
        vacantService.deleteById(id);
        logger.info("Vacant deleted with id {}", id);
        return "vacant/delete";
    }

    @GetMapping("/create")
    public String create() {
        return "vacant/create";
    }

    @PostMapping("/save")
    public String save(Vacant vacant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> logger.error(objectError.getDefaultMessage()));
            return "vacant/create";
        }
        vacantService.save(vacant);
        logger.info("Vacant saved {}", vacant);
        return "home";
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
    }

}

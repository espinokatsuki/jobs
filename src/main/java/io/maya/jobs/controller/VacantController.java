package io.maya.jobs.controller;

import io.maya.jobs.model.Vacant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/vacants")
public class VacantController {

    private final Logger logger = LoggerFactory.getLogger(VacantController.class);
    private List<Vacant> vacantList = createVacantList();

    @GetMapping("")
    public String listAll(Model model) {
        model.addAttribute("vacantList", vacantList);
        return "vacant/index";
    }

    @GetMapping("/view/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        // TODO: Search vacant in DDBB
        model.addAttribute("vacant", vacantList.get(id - 1));
        logger.info("Vacant {} called: {}", id, vacantList.get(id - 1));
        return "vacant/detail";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") int id, Model model) {
        // TODO: Delete vacant in DDBB
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

    private List<Vacant> createVacantList() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacant> list = new LinkedList<>();
        try {
            Vacant vacant1 = new Vacant();
            vacant1.setId(1);
            vacant1.setName("Game designer");
            vacant1.setDescription("Game designer to produce new games");
            vacant1.setSalary(1000.0);
            vacant1.setPublicationDate(simpleDateFormat.parse("03-06-2020"));
            vacant1.setActive(Boolean.TRUE);
            vacant1.setHighlighted(1);
            vacant1.setImage("empresa1.png");

            Vacant vacant2 = new Vacant();
            vacant2.setId(2);
            vacant2.setName("C++ game developer");
            vacant2.setDescription("Game programer with OpenGL experience");
            vacant2.setSalary(2000.0);
            vacant2.setPublicationDate(simpleDateFormat.parse("02-06-2020"));
            vacant2.setActive(Boolean.TRUE);
            vacant2.setHighlighted(0);
            vacant2.setImage("empresa2.png");

            Vacant vacant3 = new Vacant();
            vacant3.setId(3);
            vacant3.setName("Character designer");
            vacant3.setDescription("Game designer to produce new characters");
            vacant3.setSalary(3000.0);
            vacant3.setPublicationDate(simpleDateFormat.parse("01-06-2020"));
            vacant3.setActive(Boolean.TRUE);
            vacant3.setHighlighted(1);

            list.add(vacant1);
            list.add(vacant2);
            list.add(vacant3);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return list;
    }

}

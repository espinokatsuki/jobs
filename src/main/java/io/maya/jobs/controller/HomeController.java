package io.maya.jobs.controller;

import io.maya.jobs.model.Vacant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/table")
    public String getAllVancants(Model model) {
        List<Vacant> vacantList = getVacants();
        model.addAttribute("vacantList", vacantList);
        return "allVacants";
    }

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

    private List<Vacant> getVacants() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacant> vacantList = new LinkedList<>();
        try {
            Vacant vacant1 = new Vacant();
            vacant1.setId(1);
            vacant1.setName("Game designer");
            vacant1.setDescription("Game designer to produce new games");
            vacant1.setSalary(1000.0);
            vacant1.setPublicationDate(simpleDateFormat.parse("03-06-2020"));
            vacant1.setActive(Boolean.TRUE);
            vacant1.setHighlighted(1);

            Vacant vacant2 = new Vacant();
            vacant2.setId(2);
            vacant2.setName("C++ game developer");
            vacant2.setDescription("Game programer with OpenGL experience");
            vacant2.setSalary(2000.0);
            vacant2.setPublicationDate(simpleDateFormat.parse("02-06-2020"));
            vacant2.setActive(Boolean.TRUE);
            vacant2.setHighlighted(0);

            Vacant vacant3 = new Vacant();
            vacant3.setId(3);
            vacant3.setName("Character designer");
            vacant3.setDescription("Game designer to produce new characters");
            vacant3.setSalary(3000.0);
            vacant3.setPublicationDate(simpleDateFormat.parse("01-06-2020"));
            vacant3.setActive(Boolean.TRUE);
            vacant3.setHighlighted(1);

            vacantList.add(vacant1);
            vacantList.add(vacant2);
            vacantList.add(vacant3);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return vacantList;
    }

}

package io.maya.jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping("/list")
    public String listCategories() {
        return "categories/listCategories";
    }

    @GetMapping("/create")
    public String createCategory() {
        return "categories/createCategories";
    }

    @PostMapping("/save")
    public String saveCategory() {
        return "categories/listCategories";
    }

}

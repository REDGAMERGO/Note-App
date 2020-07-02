package org.reallume.controller;

import org.reallume.domain.Category;
import org.reallume.domain.Label;
import org.reallume.repos.CategoryRepo;
import org.reallume.repos.LabelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesAndLabels {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private LabelRepo labelRepo;

    @GetMapping("/categories_and_labels")
    public String main(Model model) {
        Iterable<Category> categories = categoryRepo.findAll();
        Iterable<Label> labels = labelRepo.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("labels", labels);

        return "user-pg/categories_and_labels";
    }

}

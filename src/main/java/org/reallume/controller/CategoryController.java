package org.reallume.controller;

import org.reallume.domain.Category;
import org.reallume.domain.User;
import org.reallume.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/add-category")
    public String addCategory(@AuthenticationPrincipal User user,
                              @RequestParam String name, Model model) {
        if (name != null && !name.isEmpty() && user != null) {
            Category category = new Category(name, user);

            categoryRepo.save(category);

            Iterable<Category> categories = categoryRepo.findAll();

            model.addAttribute("categories", categories);

        }
        return "redirect:/categories_and_labels";
    }

    @Transactional
    @GetMapping("/remove-category")
    public String removeCategory(@AuthenticationPrincipal User user,
                                 @RequestParam Integer category_id, Model model) {
        categoryRepo.deleteByIdAndAuthor(category_id, user);

        Iterable<Category> categories = categoryRepo.findAll();

        model.addAttribute("categories", categories);

        return "redirect:/categories_and_labels";
    }


    @PostMapping("/update-category")
    public String updateCategory(@AuthenticationPrincipal User user,
                                 @RequestParam Integer category_id,
                                 @RequestParam String name,
                                 Model model) {

        Category category = categoryRepo.findByIdAndAuthor(category_id, user);

        category.setName(name);

        category.setId(category_id);

        categoryRepo.save(category);

        Iterable<Category> categories = categoryRepo.findAll();

        model.addAttribute("categories", categories);

        return "redirect:/categories_and_labels";

    }


}

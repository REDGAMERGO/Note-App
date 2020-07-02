package org.reallume.controller;

import org.reallume.domain.Category;
import org.reallume.domain.Label;
import org.reallume.domain.User;
import org.reallume.repos.LabelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LabelController {

    @Autowired
    private LabelRepo labelRepo;

    @GetMapping("/add-label")
    public String addLabel(@AuthenticationPrincipal User user,
                              @RequestParam String name, Model model) {
        if (name != null && !name.isEmpty() && user != null) {
            Label label = new Label(name, user);

            labelRepo.save(label);

            Iterable<Label> labels = labelRepo.findAll();

            model.addAttribute("labels", labels);

        }
        return "redirect:/categories_and_labels";
    }

    @Transactional
    @GetMapping("/remove-label")
    public String removeLabel(@AuthenticationPrincipal User user,
                                 @RequestParam Integer label_id, Model model) {
        labelRepo.deleteByIdAndAuthor(label_id, user);

        Iterable<Label> labels = labelRepo.findAll();

        model.addAttribute("labels", labels);

        return "redirect:/categories_and_labels";
    }

    @PostMapping("/update-label")
    public String updateLabel(@AuthenticationPrincipal User user,
                                 @RequestParam Integer label_id,
                                 @RequestParam String name,
                                 Model model) {

        Label label = labelRepo.findByIdAndAuthor(label_id, user);

        label.setName(name);

        label.setId(label_id);

        labelRepo.save(label);

        Iterable<Label> labels = labelRepo.findAll();

        model.addAttribute("labels", labels);

        return "redirect:/categories_and_labels";

    }

}

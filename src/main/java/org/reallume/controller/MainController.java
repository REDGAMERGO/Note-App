package org.reallume.controller;

import org.reallume.domain.Category;
import org.reallume.domain.Note;
import org.reallume.domain.User;
import org.reallume.repos.CategoryRepo;
import org.reallume.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/")
    public String enter(Map<String, Object> model) {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Note> notes = noteRepo.findAll();
        Iterable<Category> categories = categoryRepo.findAll();

        model.put("categories", categories);
        model.put("notes", notes);

        return "common/main";
    }

}

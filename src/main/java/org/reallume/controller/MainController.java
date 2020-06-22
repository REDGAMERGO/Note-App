package org.reallume.controller;

import org.reallume.domain.Category;
import org.reallume.domain.Note;
import org.reallume.repos.CategoryRepo;
import org.reallume.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String greeting(Map<String, Object> model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Note> notes = noteRepo.findAll();
        Iterable<Category> categories = categoryRepo.findAll();

        model.put("categories", categories);
        model.put("notes", notes);

        return "main";
    }


    @PostMapping("addNote")
    public String addNote(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Note note = new Note(text, tag);

        noteRepo.save(note);

        Iterable<Note> notes = noteRepo.findAll();

        model.put("notes", notes);

        return "main";
    }

    @PostMapping("addCategory")
    public String addCategory(@RequestParam String name, @RequestParam String description, Map<String, Object> model) {
        Category category = new Category(name, description);

        categoryRepo.save(category);

        Iterable<Category> categories = categoryRepo.findAll();

        model.put("categories", categories);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Note> notes;

        if (filter != null && !filter.isEmpty()) {
            notes = noteRepo.findByTag(filter);
        } else {
            notes = noteRepo.findAll();
        }

        model.put("notes", notes);

        return "main";
    }

    @PostMapping("getAllCategory")
    public String getAllCategory(Map<String, Object> model) {
        Iterable<Category> categories;

        categories = categoryRepo.findAll();

        model.put("categories",categories);

        return "main";
    }

}

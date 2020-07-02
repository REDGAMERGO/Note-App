package org.reallume.controller;

import org.reallume.domain.Category;
import org.reallume.domain.Note;
import org.reallume.domain.User;
import org.reallume.repos.CategoryRepo;
import org.reallume.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class NoteController {

    @Autowired
    private NoteRepo noteRepo;

    @GetMapping("/notes")
    public String main(Map<String, Object> model) {
        Iterable<Note> notes = noteRepo.findAll();

        model.put("notes", notes);

        return "user-pg/notes";
    }

    @GetMapping("/add-note")
    public String addNote(@AuthenticationPrincipal User user,
                          @RequestParam String name,
                          @RequestParam String text,
                          @RequestParam Category category,
                          Map<String, Object> model) {
        if (name == null || name.isEmpty()) {
            name = "Без названия";
        }

        Note note = new Note(name, text, category, user);

        noteRepo.save(note);

        Iterable<Note> notes = noteRepo.findAll();

        model.put("notes", notes);

        return "redirect:/notes";
    }


    @Transactional
    @GetMapping("/remove-note")
    public String removeNote(@AuthenticationPrincipal User user,
                                 @RequestParam Integer note_id, Map<String, Object> model) {
        noteRepo.deleteByIdAndAuthor(note_id, user);

        Iterable<Note> notes = noteRepo.findAll();

        model.put("notes", notes);

        return "redirect:/notes";
    }

    @Transactional
    @GetMapping("/update-note-button")
    public String updateCategoryButton(@AuthenticationPrincipal User user,
                                       @RequestParam Integer category_id,
                                       Map<String, Object> model) {
        String name = noteRepo.findByIdAndAuthor(category_id, user).getName();


        return "redirect:/notes";
    }

    @Transactional
    @PostMapping("/update-note")
    public String updateCategory(@AuthenticationPrincipal User user,
                                 @RequestParam Integer note_id,
                                 @RequestParam String name,
                                 @RequestParam String text,
                                 @RequestParam Category category,
                                 Map<String, Object> model) {
        noteRepo.findByIdAndAuthor(note_id, user).setName(name);
        noteRepo.findByIdAndAuthor(note_id, user).setText(text);
        noteRepo.findByIdAndAuthor(note_id, user).setCategory(category);

        Iterable<Note> notes = noteRepo.findAll();

        model.put("notes", notes);

        return "redirect:/notes";

    }


}
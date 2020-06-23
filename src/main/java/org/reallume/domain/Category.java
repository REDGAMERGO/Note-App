package org.reallume.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.reallume.repos.CategoryRepo;
import org.reallume.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Note> notes;

    public Category() {
    }

    public Category(String name, User author) {
        this.name = name;
        this.author = author;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public User getAuthor() { return author; }

    public void setAuthor(User author) { this.author = author; }

    public List<Note> getNotes() { return notes; }

    public void setNotes(List<Note> notes) { this.notes = notes; }

    public Category getSelf() { return this;}

}

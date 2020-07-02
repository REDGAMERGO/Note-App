package org.reallume.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Label {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Note> notes;

    public Label() {
    }

    public Label(String name, User author) {
        this.name = name;
        this.author = author;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public User getAuthor() { return author; }

    public void setAuthor(User author) { this.author = author; }

    public Set<Note> getNotes() { return notes; }

    public void setNotes(Set<Note> notes) { this.notes = notes; }

    public Label getSelf() { return this;}

}
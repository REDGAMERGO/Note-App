package org.reallume.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String text;
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Note() {
    }

    public Note(String name, String text, Category category, User user) {
        this.name = name;
        this.text = text;
        this.category = category;
        this.time = new Date();
        this.author = user;
        this.category = category;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getTime() { return time; }

    public void setTime(Date time) { this.time = time; }

    //по Groovy можно обращаться к полю метода, который не существует. Например, getAuthorName -> поле AuthorName
    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

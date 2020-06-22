package org.reallume.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Note() {
    }

    public Note(String text, String tag) {
        this.text = text;
        this.tag = tag;
        this.time = new Date();
    }

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

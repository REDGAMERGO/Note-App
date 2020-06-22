package org.reallume.domain;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Category() {
    }

    public Category(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDesc() { return description; }

    public void setDesc(String desc) { this.description = desc; }
}

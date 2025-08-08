package com.bugra.kitaptakipapi.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Boş constructor (Spring için şart)
    public Book() {}

    // Parametreli constructor
    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    // Getter ve Setter’lar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

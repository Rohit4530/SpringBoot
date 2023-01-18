package com.book.entity;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Book implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book() {
        super();
    }

    public Book(Integer id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

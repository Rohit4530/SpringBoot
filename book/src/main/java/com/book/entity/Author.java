package com.book.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long author_id;
    private String first;
    private String last;

    public Author() {
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public Author(Long author_id, String first, String last) {
        this.author_id = author_id;
        this.first = first;
        this.last = last;
    }
}
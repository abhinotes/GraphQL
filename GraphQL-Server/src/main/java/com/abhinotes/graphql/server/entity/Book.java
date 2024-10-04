package com.abhinotes.graphql.server.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private String publishedDate;

    // Constructors, getters, and setters
    public Book() {}

    public Book(String title, String author, String publishedDate) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    // Getters and setters...
}
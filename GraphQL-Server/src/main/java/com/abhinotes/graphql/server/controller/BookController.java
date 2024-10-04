package com.abhinotes.graphql.server.controller;

import com.abhinotes.graphql.server.entity.Book;
import com.abhinotes.graphql.server.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Optional<Book> bookById(@Argument Long id) {
        return bookRepository.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument AddBookInput input) {
        Book book = new Book(input.title(), input.author(), input.publishedDate());
        return bookRepository.save(book);
    }

    // Define the AddBookInput record
    public record AddBookInput(String title, String author, String publishedDate) {}
}
package com.abhinotes.graphql.server.repository;

import com.abhinotes.graphql.server.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
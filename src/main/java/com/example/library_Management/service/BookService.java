package com.example.library_Management.service;

import com.example.library_Management.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public ResponseEntity addBook(Book book) ;

    List<Book> findAll();

    ResponseEntity<Book> findBookById(Long id);
}

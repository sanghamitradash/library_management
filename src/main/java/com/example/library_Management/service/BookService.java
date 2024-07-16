package com.example.library_Management.service;

import com.example.library_Management.entity.Book;
import com.example.library_Management.entity.User;
import org.springframework.http.ResponseEntity;

public interface BookService {
    public ResponseEntity addBook(Book book) ;
}

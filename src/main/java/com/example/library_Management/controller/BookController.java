package com.example.library_Management.controller;

import com.example.library_Management.entity.Book;
import com.example.library_Management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/allBooks")
    public List<Book> allBooks(){
        return bookService.findAll();
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }
}

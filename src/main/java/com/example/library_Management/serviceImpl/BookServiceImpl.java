package com.example.library_Management.serviceImpl;

import com.example.library_Management.entity.Book;
import com.example.library_Management.repository.BookRepository;
import com.example.library_Management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity addBook(Book book) {

        try {

            if (book.getTitle() == null || book.getTitle().isEmpty()) {
                return ResponseEntity.badRequest().body("Book title can't be empty");
            }
            bookRepository.save(book);
            return ResponseEntity.ok("Book added successfully");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
        }
    }
}

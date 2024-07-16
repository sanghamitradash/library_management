package com.example.library_Management.repository;

import com.example.library_Management.entity.Book;
import com.example.library_Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

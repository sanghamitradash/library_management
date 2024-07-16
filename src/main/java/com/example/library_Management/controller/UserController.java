package com.example.library_Management.controller;

import com.example.library_Management.entity.Book;
import com.example.library_Management.service.BookService;
import com.example.library_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.library_Management.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
         return userService.findByMobileNumber(user);
    }
}

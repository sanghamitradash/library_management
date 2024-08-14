package com.example.library_Management.service;

import com.example.library_Management.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity registerUser(User user);

    ResponseEntity findByMobileNumber(User user);

    public List<User> findAll();

    ResponseEntity<User> getUserById(Long id);
}

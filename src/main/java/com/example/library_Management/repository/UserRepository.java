package com.example.library_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library_Management.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByMobileNumber(Long mobileNumber);
}

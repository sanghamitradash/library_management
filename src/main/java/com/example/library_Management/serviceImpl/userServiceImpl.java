package com.example.library_Management.serviceImpl;

import com.example.library_Management.repository.UserRepository;
import com.example.library_Management.service.UserService;
import com.example.library_Management.entity.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //
    @Override
    public ResponseEntity registerUser(User user) {
        try {
            //validate input

            if (user.getName() == null || user.getPassword() == null) {
                return ResponseEntity.badRequest().body("Username,password are required.");
            }

            //check if the user is already taken
            Optional<User> data = userRepository.findUserByMobileNumber(user.getMobileNumber());
            if (!data.isEmpty() && data != null) {
                return ResponseEntity.badRequest().body("User name already exists.");
            }

            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }

    @Override
    public ResponseEntity findByMobileNumber(User user) {
        System.out.println("Attempting to find user by mobile number: " + user.getMobileNumber());

        //find user by mobile number
        Optional<User> optionalUser = userRepository.findUserByMobileNumber(user.getMobileNumber());

        //check if the user is present or not
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            System.out.println("User found: " + foundUser.getName());

            //validate the password
            if (foundUser.getPassword().equals(user.getPassword())) {
                System.out.println("Password match for user: " + foundUser.getName());
                return ResponseEntity.ok(foundUser);
            } else {
                System.out.println("Invalid credentials for user: " + foundUser.getName());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            System.out.println("User not found with mobile number: " + user.getMobileNumber());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return ResponseEntity.ok(optionalUser.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

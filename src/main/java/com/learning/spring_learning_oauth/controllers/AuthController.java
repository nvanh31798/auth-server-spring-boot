package com.learning.spring_learning_oauth.controllers;

import com.learning.spring_learning_oauth.entities.User;
import com.learning.spring_learning_oauth.models.request.LoginRequest;
import com.learning.spring_learning_oauth.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication API")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Endpoint for user registration")
    public ResponseEntity<?> registerUser(@RequestBody @Valid User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    @Operation(summary = "Login user", description = "Endpoint for user login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
//        userService.
        return ResponseEntity.ok("Login successful");
    }
}

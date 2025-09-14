package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // Register new user
    public User register(User user) {
        // Optional: check if email already exists
        Optional<User> existing = repository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        return repository.save(user);
    }

    // Login by email
    public Optional<User> login(String email) {
        return repository.findByEmail(email);
    }
}
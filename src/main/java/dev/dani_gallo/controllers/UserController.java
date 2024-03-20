package dev.dani_gallo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.dani_gallo.models.User;
import dev.dani_gallo.repositories.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userRepository.findByUsername(user.getUsername());
    }
}

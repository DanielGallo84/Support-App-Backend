package dev.dani_gallo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dani_gallo.models.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        // Aquí puedes agregar lógica adicional, como la validación de datos
        return userRepository.save(user);
    }
}

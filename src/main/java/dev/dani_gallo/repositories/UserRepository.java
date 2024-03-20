package dev.dani_gallo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.dani_gallo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
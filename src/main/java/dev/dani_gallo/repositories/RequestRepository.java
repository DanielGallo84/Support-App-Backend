package dev.dani_gallo.repositories;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.dani_gallo.models.Request;
import dev.dani_gallo.models.User;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByUserOrderByRequestDateDesc(User user);
}
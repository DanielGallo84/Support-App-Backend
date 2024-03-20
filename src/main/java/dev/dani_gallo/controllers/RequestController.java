package dev.dani_gallo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.dani_gallo.models.Request;
import dev.dani_gallo.models.User;
import dev.dani_gallo.services.RequestService;

@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/requests")
    public List<Request> getRequests(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return requestService.findRequestsByUser(user);
    }

    @PostMapping("/requests")
    public Request createRequest(@RequestBody Request request, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        request.setUser(user);
        return requestService.createRequest(request);
    }

    @PutMapping("/requests/{id}")
    public Request updateRequest(@PathVariable Long id, @RequestBody Request request) {
        return requestService.updateRequest(id, request);
    }
}
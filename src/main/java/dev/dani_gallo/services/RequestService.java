package dev.dani_gallo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> findRequestsByUser(User user) {
        return requestRepository.findByUserOrderByRequestDateDesc(user);
    }

    public Request createRequest(Request request) {
        // Aquí puedes agregar lógica adicional, como la validación de datos
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request request) {
        return requestRepository.findById(id).map(existingRequest -> {
            existingRequest.setSubject(request.getSubject());
            existingRequest.setDescription(request.getDescription());
            existingRequest.setStatus(request.getStatus());
            return requestRepository.save(existingRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Request not found with id " + id));
    }
}
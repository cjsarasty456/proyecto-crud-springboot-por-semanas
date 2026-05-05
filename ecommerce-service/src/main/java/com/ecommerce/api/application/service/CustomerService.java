package com.ecommerce.api.application.service;
import com.ecommerce.api.domain.model.Customer;
import com.ecommerce.api.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Customer> findAll() { return repository.findAll(); }
    public Customer save(Customer customer) {
        if(repository.findByEmail(customer.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        Customer saved = repository.save(customer);
        
        // Llamar al microservicio de notificaciones
        try {
            Map<String, String> request = new HashMap<>();
            request.put("email", saved.getEmail());
            request.put("message", "Bienvenido " + saved.getName() + " a nuestra plataforma E-commerce.");
            restTemplate.postForEntity("http://localhost:8081/api/notifications/send", request, String.class);
        } catch (Exception e) {
            System.err.println("No se pudo enviar la notificación: " + e.getMessage());
        }
        
        return saved;
    }
}
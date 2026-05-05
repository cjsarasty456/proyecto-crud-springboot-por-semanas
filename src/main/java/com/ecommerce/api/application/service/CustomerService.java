package com.ecommerce.api.application.service;
import com.ecommerce.api.domain.model.Customer;
import com.ecommerce.api.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    public List<Customer> findAll() { return repository.findAll(); }
    public Customer save(Customer customer) {
        if(repository.findByEmail(customer.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(customer);
    }
}
package com.ecommerce.api.domain.repository;
import com.ecommerce.api.domain.model.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface CustomerRepository {
    List<Customer> findAll();
    Optional<Customer> findById(UUID id);
    Optional<Customer> findByEmail(String email);
    Customer save(Customer customer);
}
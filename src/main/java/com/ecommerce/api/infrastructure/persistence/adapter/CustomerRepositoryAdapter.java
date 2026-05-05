package com.ecommerce.api.infrastructure.persistence.adapter;
import com.ecommerce.api.domain.model.Customer;
import com.ecommerce.api.domain.repository.CustomerRepository;
import com.ecommerce.api.infrastructure.persistence.entity.CustomerEntity;
import com.ecommerce.api.infrastructure.persistence.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {
    private final CustomerJpaRepository jpaRepository;
    @Override public List<Customer> findAll() { return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList()); }
    @Override public Optional<Customer> findById(UUID id) { return jpaRepository.findById(id).map(this::toDomain); }
    @Override public Optional<Customer> findByEmail(String email) { return jpaRepository.findByEmail(email).map(this::toDomain); }
    @Override public Customer save(Customer customer) { return toDomain(jpaRepository.save(toEntity(customer))); }
    
    private Customer toDomain(CustomerEntity entity) {
        Customer c = new Customer();
        c.setCustomerId(entity.getCustomerId());
        c.setName(entity.getName());
        c.setEmail(entity.getEmail());
        c.setPhone(entity.getPhone());
        return c;
    }
    private CustomerEntity toEntity(Customer domain) {
        CustomerEntity e = new CustomerEntity();
        e.setCustomerId(domain.getCustomerId());
        e.setName(domain.getName());
        e.setEmail(domain.getEmail());
        e.setPhone(domain.getPhone());
        return e;
    }
}
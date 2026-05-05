package com.ecommerce.api.service;

import com.ecommerce.api.dto.CustomerDTO;
import com.ecommerce.api.entity.Customer;
import com.ecommerce.api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public List<CustomerDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CustomerDTO findById(UUID id) {
        return repository.findById(id).map(this::toDTO).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public CustomerDTO save(CustomerDTO dto) {
        if(repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        Customer entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    private CustomerDTO toDTO(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(entity.getCustomerId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    private Customer toEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setCustomerId(dto.getCustomerId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}

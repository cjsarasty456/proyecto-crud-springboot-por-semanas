package com.ecommerce.api.infrastructure.web.controller;
import com.ecommerce.api.application.service.CustomerService;
import com.ecommerce.api.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    @GetMapping
    public ResponseEntity<List<Customer>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) { return ResponseEntity.ok(service.save(customer)); }
}
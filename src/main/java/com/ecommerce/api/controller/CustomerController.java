package com.ecommerce.api.controller;

import com.ecommerce.api.dto.CustomerDTO;
import com.ecommerce.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CustomerDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}

package com.ecommerce.api.infrastructure.web.controller;
import com.ecommerce.api.application.service.ProductService;
import com.ecommerce.api.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    @GetMapping
    public ResponseEntity<List<Product>> getAll() { return ResponseEntity.ok(service.findAll()); }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) { return ResponseEntity.ok(service.save(product)); }
}
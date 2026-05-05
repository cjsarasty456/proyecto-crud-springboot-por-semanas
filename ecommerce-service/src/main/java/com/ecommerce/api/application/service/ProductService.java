package com.ecommerce.api.application.service;
import com.ecommerce.api.domain.model.Product;
import com.ecommerce.api.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    public List<Product> findAll() { return repository.findAll(); }
    public Product save(Product product) { return repository.save(product); }
}
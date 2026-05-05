package com.ecommerce.api.domain.repository;
import com.ecommerce.api.domain.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(UUID id);
    Product save(Product product);
}
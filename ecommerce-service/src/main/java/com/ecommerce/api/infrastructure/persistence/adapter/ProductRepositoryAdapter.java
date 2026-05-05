package com.ecommerce.api.infrastructure.persistence.adapter;
import com.ecommerce.api.domain.model.Product;
import com.ecommerce.api.domain.repository.ProductRepository;
import com.ecommerce.api.infrastructure.persistence.entity.ProductEntity;
import com.ecommerce.api.infrastructure.persistence.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {
    private final ProductJpaRepository jpaRepository;
    @Override public List<Product> findAll() { return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList()); }
    @Override public Optional<Product> findById(UUID id) { return jpaRepository.findById(id).map(this::toDomain); }
    @Override public Product save(Product product) { return toDomain(jpaRepository.save(toEntity(product))); }
    
    private Product toDomain(ProductEntity entity) {
        Product p = new Product();
        p.setProductId(entity.getProductId());
        p.setName(entity.getName());
        p.setPrice(entity.getPrice());
        return p;
    }
    private ProductEntity toEntity(Product domain) {
        ProductEntity e = new ProductEntity();
        e.setProductId(domain.getProductId());
        e.setName(domain.getName());
        e.setPrice(domain.getPrice());
        return e;
    }
}
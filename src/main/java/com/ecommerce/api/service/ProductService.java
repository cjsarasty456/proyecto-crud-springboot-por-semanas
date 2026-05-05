package com.ecommerce.api.service;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.entity.Product;
import com.ecommerce.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<ProductDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProductDTO save(ProductDTO dto) {
        Product entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    private ProductDTO toDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    private Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setProductId(dto.getProductId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}

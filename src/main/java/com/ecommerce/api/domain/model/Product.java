package com.ecommerce.api.domain.model;
import java.util.UUID;
import java.math.BigDecimal;
import lombok.Data;
@Data
public class Product {
    private UUID productId;
    private String name;
    private BigDecimal price;
}
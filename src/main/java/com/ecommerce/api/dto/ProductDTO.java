package com.ecommerce.api.dto;

import lombok.Data;
import java.util.UUID;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
public class ProductDTO {
    private UUID productId;
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private BigDecimal price;
}

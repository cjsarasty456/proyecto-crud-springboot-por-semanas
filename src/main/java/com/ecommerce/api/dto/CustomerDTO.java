package com.ecommerce.api.dto;

import lombok.Data;
import java.util.UUID;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class CustomerDTO {
    private UUID customerId;
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    private String phone;
}

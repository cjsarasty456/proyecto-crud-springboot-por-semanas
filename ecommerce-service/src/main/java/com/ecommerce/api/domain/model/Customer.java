package com.ecommerce.api.domain.model;
import java.util.UUID;
import lombok.Data;
@Data
public class Customer {
    private UUID customerId;
    private String name;
    private String email;
    private String phone;
}
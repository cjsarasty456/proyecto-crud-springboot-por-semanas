package com.ecommerce.api.infrastructure.persistence.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;
@Entity
@Table(name = "customers")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerId;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
}
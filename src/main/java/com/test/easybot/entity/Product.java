package com.test.easybot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Enumerated(EnumType.STRING)
    private ProductTypeEnum productType;

    @Column(name = "productExtra")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_product_details",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_details_id")})
    private List<ProductExtraDetails> productExtra;

}

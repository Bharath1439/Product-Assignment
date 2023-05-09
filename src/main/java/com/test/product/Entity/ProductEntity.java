package com.test.product.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;


    @Column(nullable = false)
    private String productBrand;

    @Column(nullable = false)
    private String productColor;

    @Column(nullable = false)
    private int productPrice;

    @Column(nullable = false)
    private String description;

    public ProductEntity(int productId, String productBrand, String productColor, int productPrice, String description, String suitableAge, String productType) {
        this.productId = productId;
        this.productBrand = productBrand;
        this.productColor = productColor;
        this.productPrice = productPrice;
        this.description = description;
        this.suitableAge = suitableAge;
        this.ProductType = productType;

    }

    @Column(nullable = false)
    private String suitableAge;



    @Column(nullable = false)
    private String ProductType;

    @ManyToOne
    @JoinColumn
    private CategoryEntity categoryEntity;

}

package com.test.product.RequestDto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class product {

    @Column(nullable = false)
    private String productBrand;

    @Column(nullable = false)
    private String productColor;

    @Column(nullable = false)
    private int productPrice;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String ProductType;

    @Column(nullable = false)
    private String suitableAge;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String suitableGender;


}

package com.test.product.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(nullable = false)
    private String categoryName;

    public CategoryEntity(String categoryName, String suitableGender) {
        this.categoryName = categoryName;
        this.suitableGender = suitableGender;
    }

    @Column(nullable = false)
    private String suitableGender;

    @OneToMany(mappedBy = "categoryEntity",cascade = CascadeType.ALL)
    private List<ProductEntity> productEntityList;


}

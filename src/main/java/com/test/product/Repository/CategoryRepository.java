package com.test.product.Repository;

import com.test.product.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {

    @Query("SELECT c FROM CategoryEntity c WHERE c.categoryName = :categoryName AND c.suitableGender = :suitableGender")
    CategoryEntity findByNameAndGender(String suitableGender, String categoryName);
}

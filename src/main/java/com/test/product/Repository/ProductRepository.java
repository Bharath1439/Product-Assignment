package com.test.product.Repository;

import com.test.product.Entity.CategoryEntity;
import com.test.product.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

}

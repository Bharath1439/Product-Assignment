package com.test.product.Controller;

import com.test.product.Entity.CategoryEntity;
import com.test.product.Repository.CategoryRepository;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    public void AddCategory(String categoryName,String suitableGender){
        CategoryEntity categoryEntity=new CategoryEntity(categoryName,suitableGender);
        categoryRepository.save(categoryEntity);

    }
}

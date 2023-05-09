package com.test.product;

import com.test.product.Entity.CategoryEntity;
import com.test.product.Entity.ProductEntity;
import com.test.product.Repository.CategoryRepository;
import com.test.product.Repository.ProductRepository;
import com.test.product.RequestDto.product;
import com.test.product.Service.ProductService;
import com.test.product.serviceImp.ProductServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImp productServiceImp;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListProducts() {
        // Create a mock list of products
        List<ProductEntity> mockProductList = new ArrayList<>();
        mockProductList.add(new ProductEntity(1, "Brand 1", "Blue", 100, "Description 1", "Age 1", "Type 1"));
        mockProductList.add(new ProductEntity(2, "Brand 2", "Red", 200, "Description 2", "Age 2", "Type 2"));

        // Mock the behavior of productRepository.findAll()
        when(productRepository.findAll()).thenReturn(mockProductList);

        // Call the method under test
        List<ProductEntity> result = productServiceImp.listProducts();

        // Verify the result
        assertEquals(mockProductList, result);
    }


    @Test
    public void testSaveProduct() {
        // Initialize the Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create a mock product entity
        product prod = new product();
        prod.setProductBrand(null);
        prod.setProductColor("brand");
        prod.setProductPrice(3273);
        prod.setDescription("brand");
        prod.setProductType("brand");
        prod.setSuitableAge("brand");
        prod.setSuitableGender("brand");
        prod.setCategoryName("brand");
        // Set the necessary properties of the product

        // Create a mock category entity
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(prod.getCategoryName());
        category.setSuitableGender(prod.getSuitableGender());
        // Set the necessary properties of the category

        // Mock the behavior of the category repository
        when(categoryRepository.findByNameAndGender(anyString(), anyString())).thenReturn(category);

        // Call the method under test
        ProductEntity result = productServiceImp.saveProduct(prod);

        // Verify the product entity is saved in the product repository
        verify(productRepository, times(1)).save(result);

        // Assert the result is not null
        assertNotNull(result);
        // Add more assertions as needed
    }
    @Test
    public void testUpdateProduct() {
        // Initialize the Mockito annotations
        MockitoAnnotations.initMocks(this);

        // Create a mock product entity
        ProductEntity prod = new ProductEntity();
        prod.setProductBrand(null);
        prod.setProductColor("brand");
        prod.setProductPrice(3273);
        prod.setDescription("cool");
        prod.setProductType("formal");
        prod.setSuitableAge("kids");
        // Set the necessary properties of the product entity

        // Create a mock existing product entity
        ProductEntity exProd = new ProductEntity();
        exProd.setProductBrand(null);
        exProd.setProductColor("brand");
        exProd.setProductPrice(327);
        exProd.setDescription("cool");
        exProd.setProductType("formal");
        exProd.setSuitableAge("kids");
        // Set the necessary properties of the existing product entity

        // Mock the behavior of the product repository
        when(productRepository.findById(anyInt())).thenReturn(java.util.Optional.of(exProd));
        when(productRepository.save(any(ProductEntity.class))).thenReturn(exProd);

        // Call the method under test
        ProductEntity result = productServiceImp.UpdateProduct(1, prod);

        // Verify the product entity is retrieved from the product repository
        verify(productRepository, times(1)).findById(1);
        // Verify the updated product entity is saved in the product repository
        verify(productRepository, times(1)).save(exProd);

        // Assert the result is the same as the existing product entity
        assertEquals(exProd, result);
        // Add more assertions as needed
    }


}
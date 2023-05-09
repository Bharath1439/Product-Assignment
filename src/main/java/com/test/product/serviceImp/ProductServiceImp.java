package com.test.product.serviceImp;


import com.test.product.Entity.CategoryEntity;
import com.test.product.Entity.ProductEntity;
import com.test.product.Repository.CategoryRepository;
import com.test.product.Repository.ProductRepository;
import com.test.product.RequestDto.product;
import com.test.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<ProductEntity> listProducts(){
        List<ProductEntity> list=productRepository.findAll();
        return list;
    }
    @Override
    public ProductEntity saveProduct(product product){
       ProductEntity productEntity= ProductEntity.builder().productBrand(product.getProductBrand()).productColor(product.getProductColor()).productPrice(product.getProductPrice()).description(product.getDescription()).suitableAge(product.getSuitableAge()).ProductType(product.getProductType()).build();
       CategoryEntity c1=categoryRepository.findByNameAndGender(product.getSuitableGender(), product.getCategoryName());
       if(c1==null){
           throw new RuntimeException();
       }

       if(c1.getCategoryName().contentEquals("shoes") && c1.getSuitableGender().contentEquals("male")){
           productEntity.setCategoryEntity(c1);
       }
       else if(c1.getCategoryName().contentEquals("shoes") && c1.getSuitableGender().contentEquals("female")){
           productEntity.setCategoryEntity(c1);
       }
       else if(c1.getCategoryName().contentEquals("mobile") && c1.getSuitableGender().contentEquals("all")){
           productEntity.setCategoryEntity(c1);
       }
       else if(c1.getCategoryName().contentEquals("cloths") && c1.getSuitableGender().contentEquals("male")){
           productEntity.setCategoryEntity(c1);
       }
       else if(c1.getCategoryName().contentEquals("cloths") && c1.getSuitableGender().contentEquals("female")){
           productEntity.setCategoryEntity(c1);
       }
       else if(c1.getCategoryName().contentEquals("cloths") && c1.getSuitableGender().contentEquals("all")){
           productEntity.setCategoryEntity(c1);
       }
       else if(c1.getCategoryName().contentEquals("shoes") && c1.getSuitableGender().contentEquals("all")){
           productEntity.setCategoryEntity(c1);
       }
       productRepository.save(productEntity);
       return productEntity;

    }
    @Override
    public ProductEntity UpdateProduct(int id,ProductEntity productEntity){
        ProductEntity ExistingProduct=productRepository.findById(id).get();
        ExistingProduct.setProductBrand(productEntity.getProductBrand());
        ExistingProduct.setProductColor(productEntity.getProductColor());
        ExistingProduct.setProductType(productEntity.getProductType());
        ExistingProduct.setDescription(productEntity.getDescription());
        ExistingProduct.setProductPrice(productEntity.getProductPrice());
        ExistingProduct.setSuitableAge(productEntity.getSuitableAge());
        return productRepository.save(ExistingProduct);
    }

}

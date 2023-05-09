package com.test.product.Controller;


import com.test.product.Entity.ProductEntity;
import com.test.product.Repository.ProductRepository;
import com.test.product.RequestDto.product;
import com.test.product.serviceImp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductServiceImp productServiceImp;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/Product")
    public String listProducts(Model model) {
        List<ProductEntity> products=productServiceImp.listProducts();
        model.addAttribute("products",products);
        return("products");
    }
    @GetMapping(value="/Product/new")
    public String newProduct(Model model){
        product product=new product();
        model.addAttribute("product", product);
        return "create_product";
    }
    @PostMapping(value = "/Products")
    public String saveProduct(@ModelAttribute("product") product product,Model model) {
        try {
            productServiceImp.saveProduct(product);
        }
        catch(Exception e){
              String ErrorMessage=e.toString();
              model.addAttribute("ErrorMessage", ErrorMessage);
              return "error";
        }
        return "redirect:/Product";
    }
    @GetMapping(value="/Product/edit/{id}")
    public String getProduct(@PathVariable int id, Model model){
        model.addAttribute("product",productRepository.findById(id).get());
        return "edit_product";
    }
    @PostMapping(value = "/Product/{id}")
    public String UpdateProduct(@PathVariable int id,@ModelAttribute("product") ProductEntity productEntity){
        productServiceImp.UpdateProduct(id,productEntity);
        return "redirect:/Product";
    }
    @GetMapping (value = "/Product/{id}")
    public String DelecteProduct(@PathVariable int id){
        productRepository.deleteById(id);
        return "redirect:/Product";
    }



}

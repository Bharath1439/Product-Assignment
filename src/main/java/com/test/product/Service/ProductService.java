package com.test.product.Service;

import com.test.product.Entity.ProductEntity;
import com.test.product.RequestDto.product;
import java.util.List;

public interface ProductService {
    List<ProductEntity> listProducts();

    ProductEntity saveProduct(product product);

    ProductEntity UpdateProduct(int id,ProductEntity productEntity);
}

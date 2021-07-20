package com.dqtri.myCompany.service;


import com.dqtri.myCompany.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getProductList();

    Product getProductById(Long productId);

    void deleteProductById(Long productId);
}

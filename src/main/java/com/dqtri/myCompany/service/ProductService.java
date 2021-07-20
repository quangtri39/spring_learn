package com.dqtri.myCompany.service;


import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getProductList();

    Product getProductById(Long productId) throws ProductNotFoundException;

    void deleteProductById(Long productId) throws ProductNotFoundException;

    List<Product> getProductByName(String nameProduct);
}

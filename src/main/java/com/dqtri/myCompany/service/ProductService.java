package com.dqtri.myCompany.service;


import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.entity.ProductDto;
import com.dqtri.myCompany.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    List<ProductDto> getProductList();

    ProductDto getProductById(Long productId) throws ProductNotFoundException;

    void deleteProductById(Long productId) throws ProductNotFoundException;

    List<ProductDto> getProductByName(String nameProduct);
}

package com.dqtri.myCompany.controller;

import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.entity.ProductDto;
import com.dqtri.myCompany.exception.ProductNotFoundException;
import com.dqtri.myCompany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getProductList(){
        return productService.getProductList();
    }
    @PostMapping("/products")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productService.getProductById(productId);
    }

    @GetMapping("/products/name/{name}")
    public List<ProductDto> getProductByName(@PathVariable("name") String nameProduct) throws ProductNotFoundException {
        return productService.getProductByName(nameProduct);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable("id") Long productId) throws ProductNotFoundException {
        productService.deleteProductById(productId);
        return "Product delete success!";
    }
}

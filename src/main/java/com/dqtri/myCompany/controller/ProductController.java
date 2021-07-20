package com.dqtri.myCompany.controller;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.service.ProductService;
import com.dqtri.myCompany.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProductList(){
        return productService.getProductList();
    }
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId){
        return productService.getProductById(productId);
    }
    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable("id") Long productId){
        productService.deleteProductById(productId);
        return "Product delete success!";
    }
}

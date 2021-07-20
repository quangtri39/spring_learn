package com.dqtri.myCompany.service;

import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public void deleteProductById(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            System.out.println("ChamHoi");
            throw new IllegalStateException("Product by Id: " + productId + " is not exists!");
        }
        System.out.println("nope");
        productRepository.deleteById(productId);
    }

}

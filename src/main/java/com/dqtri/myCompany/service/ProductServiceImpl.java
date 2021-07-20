package com.dqtri.myCompany.service;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.exception.CategoryNotFoundException;
import com.dqtri.myCompany.exception.ProductNotFoundException;
import com.dqtri.myCompany.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Product getProductById(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent()){
            throw new ProductNotFoundException
                    ("Product by id " + productId + " is not exists!");
        }
        return product.get();
    }

    @Override
    public void deleteProductById(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent()){
            throw new ProductNotFoundException("Product by id " + productId + " is not exists!");
        }
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getProductByName(String nameProduct) {
        return productRepository.findByName(nameProduct);
    }

}

package com.dqtri.myCompany.service;

import com.dqtri.myCompany.Converter.ProductConverter;
import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.entity.ProductDto;
import com.dqtri.myCompany.exception.ProductNotFoundException;
import com.dqtri.myCompany.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductConverter converter = new ProductConverter();
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = converter.productDTOToEntity(productDto);
        Product returnProduct =  productRepository.save(product);
        return converter.productEntityToDTO(returnProduct);
    }

    @Override
    public List<ProductDto> getProductList() {
        return converter.listProductEntityToListDTO(productRepository.findAll());
    }

    @Override
    public ProductDto getProductById(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent()){
            throw new ProductNotFoundException
                    ("Product by id " + productId + " is not exists!");
        }
        return converter.productEntityToDTO(product.get());
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
    public List<ProductDto> getProductByName(String nameProduct) {
        List<Product> productList = productRepository.findByName(nameProduct);
        return converter.listProductEntityToListDTO(productList);
    }

}

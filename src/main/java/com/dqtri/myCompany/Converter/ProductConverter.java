package com.dqtri.myCompany.Converter;

import com.dqtri.myCompany.entity.Product;
import com.dqtri.myCompany.entity.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter {
    public ProductDto productEntityToDTO(Product product){
        ProductDto productDto = new ProductDto();
        productDto.loadFromEntity(product);
        return productDto;
    }
    public List<ProductDto> listProductEntityToListDTO(List<Product> productList){
        List<ProductDto> dtoList = new ArrayList<>();
        for(Product product : productList){
            dtoList.add(productEntityToDTO(product));
        }
        return dtoList;
    }
    public Product productDTOToEntity(ProductDto productDto){
        Product product = new Product();
        product.loadFromDto(productDto);
        return product;
    }
}

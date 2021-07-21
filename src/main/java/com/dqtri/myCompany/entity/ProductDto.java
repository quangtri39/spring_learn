package com.dqtri.myCompany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String Description;
    private LocalDate createdDate;

    public void loadFromEntity(Product product){
        this.name = product.getName();
        this.Description = product.getDescription();
        this.createdDate = product.getCreatedDate();
    }

}

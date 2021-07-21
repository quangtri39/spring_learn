package com.dqtri.myCompany.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String name;
    private LocalDate createdDate;

    public void loadFromEntity(Category category){
        this.name = category.getName();
        this.createdDate = category.getCreatedDate();
    }
}

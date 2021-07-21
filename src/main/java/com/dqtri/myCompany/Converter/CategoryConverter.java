package com.dqtri.myCompany.Converter;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.entity.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryConverter {
    public CategoryDto categoryEntityToDTO(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setCreatedDate(category.getCreatedDate());
        return categoryDto;
    }
    public List<CategoryDto> listCategoryEntityToListDTO(List<Category> categoryList){
        List<CategoryDto> dtoList = new ArrayList<>();
        for(Category category : categoryList){
            dtoList.add(categoryEntityToDTO(category));
        }
        return dtoList;
    }
    public Category categoryDTOToEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setCreatedDate(categoryDto.getCreatedDate());
        return category;
    }
}

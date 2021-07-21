package com.dqtri.myCompany.service;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.entity.CategoryDto;
import com.dqtri.myCompany.exception.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategoryList();

    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long categoryId) throws CategoryNotFoundException;

    void deleteCategoryById(Long categoryId) throws CategoryNotFoundException;
}

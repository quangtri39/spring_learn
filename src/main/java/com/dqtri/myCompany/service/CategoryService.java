package com.dqtri.myCompany.service;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.exception.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList();

    Category saveCategory(Category category);

    Category getCategoryById(Long categoryId) throws CategoryNotFoundException;

    void deleteCategoryById(Long categoryId) throws CategoryNotFoundException;
}

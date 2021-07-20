package com.dqtri.myCompany.service;

import com.dqtri.myCompany.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList();

    Category saveCategory(Category category);

    Category getCategoryById(Long categoryId);

    void deleteCategoryById(Long categoryId);
}

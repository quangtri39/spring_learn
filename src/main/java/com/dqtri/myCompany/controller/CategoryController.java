package com.dqtri.myCompany.controller;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getProductList(){
        return categoryService.getCategoryList();
    }

    @PostMapping("/categories")
    public Category saveProduct(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategoryById(@PathVariable("id") Long categoryId){
        categoryService.deleteCategoryById(categoryId);
        return "Categories delete success!";
    }
}

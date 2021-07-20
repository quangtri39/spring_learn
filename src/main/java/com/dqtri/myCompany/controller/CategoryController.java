package com.dqtri.myCompany.controller;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.exception.CategoryNotFoundException;
import com.dqtri.myCompany.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Category getCategoryById(@PathVariable("id") Long categoryId) throws CategoryNotFoundException {
        return categoryService.getCategoryById(categoryId);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long categoryId) throws CategoryNotFoundException {
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<String>("Categories delete success!", HttpStatus.OK);
    }
}

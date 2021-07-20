package com.dqtri.myCompany.service;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.exception.CategoryNotFoundException;
import com.dqtri.myCompany.repository.CaterogyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CaterogyRepository caterogyRepository;
    @Override
    public List<Category> getCategoryList() {
        return caterogyRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return caterogyRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> category = caterogyRepository.findById(categoryId);
        if(!category.isPresent()){
            throw new CategoryNotFoundException("Category by id " + categoryId + " is not exists!");
        }
        return category.get();
    }

    @Override
    public void deleteCategoryById(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> category = caterogyRepository.findById(categoryId);
        if(!category.isPresent()){
            throw new CategoryNotFoundException("Category by id " + categoryId + " is not exists!");
        }
        caterogyRepository.deleteById(categoryId);
    }
}

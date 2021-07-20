package com.dqtri.myCompany.service;

import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.repository.CaterogyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Category getCategoryById(Long categoryId) {
        return caterogyRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        boolean exists = caterogyRepository.existsById(categoryId);
        if(!exists){
            throw new IllegalStateException("Category by Id: " + categoryId + " is not exists!");
        }
        caterogyRepository.deleteById(categoryId);
    }
}

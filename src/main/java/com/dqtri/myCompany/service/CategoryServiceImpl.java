package com.dqtri.myCompany.service;

import com.dqtri.myCompany.Converter.CategoryConverter;
import com.dqtri.myCompany.entity.Category;
import com.dqtri.myCompany.entity.CategoryDto;
import com.dqtri.myCompany.exception.CategoryNotFoundException;
import com.dqtri.myCompany.repository.CaterogyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryConverter converter = new CategoryConverter();
    @Autowired
    private CaterogyRepository caterogyRepository;
    @Override
    public List<CategoryDto> getCategoryList() {
        return converter.listCategoryEntityToListDTO(caterogyRepository.findAll());
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = converter.categoryDTOToEntity(categoryDto);
        Category returnCategory = caterogyRepository.save(category);
        return converter.categoryEntityToDTO(returnCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> category = caterogyRepository.findById(categoryId);
        if(!category.isPresent()){
            throw new CategoryNotFoundException("Category by id " + categoryId + " is not exists!");
        }
        return converter.categoryEntityToDTO(category.get());
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

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CourseCategory;
import com.example.demo.repository.CourseCategoryRepository;
import com.example.demo.service.intrf.CourseCategoryService;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryRepository repository;

    @Override
    public CourseCategory saveCategory(CourseCategory category) {
        return repository.save(category);
    }

    @Override
    public List<CourseCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public CourseCategory getCategoryById(Integer categoryId) {
        return repository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public CourseCategory updateCategory(Integer categoryId, CourseCategory category) {

        CourseCategory existing = getCategoryById(categoryId);

        existing.setName(category.getName());
        existing.setAgeGroup(category.getAgeGroup());
        existing.setDescription(category.getDescription());
        existing.setIsActive(category.getIsActive());

        return repository.save(existing);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        repository.deleteById(categoryId);
    }

    @Override
    public CourseCategory getCategoryByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<CourseCategory> getActiveCategories(Boolean isActive) {
        return repository.findByIsActive(isActive);
    }
}
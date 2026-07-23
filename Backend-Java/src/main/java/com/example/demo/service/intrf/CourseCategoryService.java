package com.example.demo.service.intrf;

import java.util.List;

import com.example.demo.entity.CourseCategory;

public interface CourseCategoryService {

    CourseCategory saveCategory(CourseCategory category);

    List<CourseCategory> getAllCategories();

    CourseCategory getCategoryById(Integer categoryId);

    CourseCategory updateCategory(Integer categoryId, CourseCategory category);

    void deleteCategory(Integer categoryId);

    CourseCategory getCategoryByName(String name);

    List<CourseCategory> getActiveCategories(Boolean isActive);
}
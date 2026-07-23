package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CourseCategory;
import com.example.demo.service.intrf.CourseCategoryService;

@RestController
@RequestMapping("/course-categories")
@CrossOrigin("*")
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService service;

    @PostMapping
    public CourseCategory saveCategory(@RequestBody CourseCategory category) {
        return service.saveCategory(category);
    }

    @GetMapping
    public List<CourseCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public CourseCategory getCategory(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CourseCategory updateCategory(@PathVariable Integer id,
                                         @RequestBody CourseCategory category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        service.deleteCategory(id);
        return "Course Category deleted successfully";
    }

    @GetMapping("/name/{name}")
    public CourseCategory getByName(@PathVariable String name) {
        return service.getCategoryByName(name);
    }

    @GetMapping("/active/{status}")
    public List<CourseCategory> getActive(@PathVariable Boolean status) {
        return service.getActiveCategories(status);
    }
}
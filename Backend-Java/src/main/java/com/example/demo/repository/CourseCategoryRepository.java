package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CourseCategory;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Integer> {

    Optional<CourseCategory> findByName(String name);

    List<CourseCategory> findByIsActive(Boolean isActive);

}
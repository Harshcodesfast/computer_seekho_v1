package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Testimonial;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Integer> {

    // Returns only approved testimonials
    List<Testimonial> findByIsApprovedTrue();

}
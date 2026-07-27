package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Testimonial;
import com.example.demo.repository.TestimonialRepository;
import com.example.demo.service.intrf.TestimonialService;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public List<Testimonial> getApprovedTestimonials() {
        return testimonialRepository.findByIsApprovedTrue();
    }

}
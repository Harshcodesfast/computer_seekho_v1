package com.example.demo.service.intrf;

import java.util.List;

import com.example.demo.entity.Testimonial;

public interface TestimonialService {

    List<Testimonial> getApprovedTestimonials();

}
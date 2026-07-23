package com.example.demo.dto.response;

import java.util.List;

public class HomeResponse {

    private BannerResponse banner;

    private List<CourseResponse> courses;
    private List<TestimonialResponse> testimonials;

    public HomeResponse() {
    }

    public BannerResponse getBanner() {
        return banner;
    }

    public void setBanner(BannerResponse banner) {
        this.banner = banner;
    }

    public List<CourseResponse> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseResponse> courses) {
        this.courses = courses;
    }

    // Getter for testimonials
    public List<TestimonialResponse> getTestimonials() {
        return testimonials;
    }

    // Setter for testimonials
    public void setTestimonials(List<TestimonialResponse> testimonials) {
        this.testimonials = testimonials;
    }
}
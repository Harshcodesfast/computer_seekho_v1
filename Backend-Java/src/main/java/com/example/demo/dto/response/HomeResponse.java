package com.example.demo.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeResponse {

    private List<AnnouncementResponse> announcements;
    private HeroResponse hero;
    private List<CourseResponse> courses;
    private List<TestimonialResponse> testimonials;
}

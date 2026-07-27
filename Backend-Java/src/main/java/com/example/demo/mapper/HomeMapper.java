package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.response.AnnouncementResponse;
import com.example.demo.dto.response.CourseResponse;
import com.example.demo.dto.response.HeroHighlightResponse;
import com.example.demo.dto.response.HeroResponse;
import com.example.demo.dto.response.TestimonialResponse;
import com.example.demo.entity.Course;
import com.example.demo.entity.HeroContent;
import com.example.demo.entity.HeroHighlight;
import com.example.demo.entity.NewsEvent;
import com.example.demo.entity.Testimonial;

@Component
public class HomeMapper {

    public AnnouncementResponse toAnnouncementResponse(NewsEvent newsEvent) {
        AnnouncementResponse response = new AnnouncementResponse();
        response.setId(newsEvent.getNewsId());
        response.setTitle(newsEvent.getTitle());
        response.setImageUrl(newsEvent.getImageUrl());
        return response;
    }

    public List<AnnouncementResponse> toAnnouncementResponses(List<NewsEvent> newsEvents) {
        return newsEvents.stream()
                .map(this::toAnnouncementResponse)
                .collect(Collectors.toList());
    }

    public HeroResponse toHeroResponse(HeroContent heroContent, List<HeroHighlight> highlights) {
        HeroResponse response = new HeroResponse();
        response.setTitle(heroContent.getTitle());
        response.setSubtitle(heroContent.getSubtitle());
        response.setHighlights(toHeroHighlightResponses(highlights));
        return response;
    }

    public HeroHighlightResponse toHeroHighlightResponse(HeroHighlight highlight) {
        HeroHighlightResponse response = new HeroHighlightResponse();
        response.setTitle(highlight.getTitle());
        response.setSubtitle(highlight.getSubtitle());
        response.setIcon(highlight.getIcon());
        return response;
    }

    public List<HeroHighlightResponse> toHeroHighlightResponses(List<HeroHighlight> highlights) {
        return highlights.stream()
                .map(this::toHeroHighlightResponse)
                .collect(Collectors.toList());
    }

    public CourseResponse toCourseResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setCourseId(course.getCourseId());
        response.setName(course.getName());
        response.setDescription(course.getDescription());
        response.setDuration(course.getDuration());
        response.setFees(course.getFees());
        response.setCoverPhoto(course.getCoverPhoto());
        response.setCategoryName(course.getCategory().getName());
        response.setLevel(course.getLevel().name());
        return response;
    }

    public List<CourseResponse> toCourseResponses(List<Course> courses) {
        return courses.stream()
                .map(this::toCourseResponse)
                .collect(Collectors.toList());
    }

    public TestimonialResponse toTestimonialResponse(Testimonial testimonial) {
        TestimonialResponse response = new TestimonialResponse();
        response.setName(testimonial.getName());
        response.setContent(testimonial.getContent());
        response.setRating(testimonial.getRating());
        response.setPhotoUrl(testimonial.getPhotoUrl());
        return response;
    }

    public List<TestimonialResponse> toTestimonialResponses(List<Testimonial> testimonials) {
        return testimonials.stream()
                .map(this::toTestimonialResponse)
                .collect(Collectors.toList());
    }
}

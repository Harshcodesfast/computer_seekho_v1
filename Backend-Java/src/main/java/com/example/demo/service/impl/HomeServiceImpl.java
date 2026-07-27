package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.request.EnquiryRequest;
import com.example.demo.dto.response.EnquiryResponse;
import com.example.demo.dto.response.HomeResponse;
import com.example.demo.entity.Course;
import com.example.demo.entity.HeroContent;
import com.example.demo.entity.Inquiry;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.HeroContentRepository;
import com.example.demo.repository.HeroHighlightRepository;
import com.example.demo.repository.InquiryRepository;
import com.example.demo.repository.NewsEventRepository;
import com.example.demo.repository.TestimonialRepository;

@Service
public class HomeServiceImpl implements com.example.demo.service.intrf.HomeService {

    private final NewsEventRepository newsEventRepository;
    private final HeroContentRepository heroContentRepository;
    private final HeroHighlightRepository heroHighlightRepository;
    private final CourseRepository courseRepository;
    private final TestimonialRepository testimonialRepository;
    private final InquiryRepository inquiryRepository;
    private final HomeMapper homeMapper;

    public HomeServiceImpl(
            NewsEventRepository newsEventRepository,
            HeroContentRepository heroContentRepository,
            HeroHighlightRepository heroHighlightRepository,
            CourseRepository courseRepository,
            TestimonialRepository testimonialRepository,
            InquiryRepository inquiryRepository,
            HomeMapper homeMapper) {
        this.newsEventRepository = newsEventRepository;
        this.heroContentRepository = heroContentRepository;
        this.heroHighlightRepository = heroHighlightRepository;
        this.courseRepository = courseRepository;
        this.testimonialRepository = testimonialRepository;
        this.inquiryRepository = inquiryRepository;
        this.homeMapper = homeMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public HomeResponse getHomePage() {
        HomeResponse response = new HomeResponse();

        response.setAnnouncements(
                homeMapper.toAnnouncementResponses(
                        newsEventRepository.findByIsActiveTrueOrderByCreatedAtDesc()));

        HeroContent heroContent = heroContentRepository
                .findFirstByIsActiveTrueOrderByHeroIdAsc()
                .orElseGet(this::defaultHeroContent);

        response.setHero(homeMapper.toHeroResponse(
                heroContent,
                heroHighlightRepository.findByIsActiveTrueOrderByDisplayOrderAsc()));

        response.setCourses(
                homeMapper.toCourseResponses(
                        courseRepository.findActiveCoursesWithCategory()));

        response.setTestimonials(
                homeMapper.toTestimonialResponses(
                        testimonialRepository.findByIsApprovedTrue()));

        return response;
    }

    @Override
    @Transactional
    public EnquiryResponse submitEnquiry(EnquiryRequest request) {
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Course not found with id: " + request.getCourseId()));

        Inquiry inquiry = new Inquiry();
        inquiry.setEnquirerName(request.getEnquirerName());
        inquiry.setEmail(request.getEmail());
        inquiry.setPhone(request.getPhone());
        inquiry.setMessage(request.getMessage());
        inquiry.setCourse(course);
        inquiry.setSource("website");

        Inquiry saved = inquiryRepository.save(inquiry);

        return new EnquiryResponse(
                saved.getInquiryId(),
                "Enquiry submitted successfully. Our team will contact you soon.");
    }

    private HeroContent defaultHeroContent() {
        HeroContent heroContent = new HeroContent();
        heroContent.setTitle("Empowering Careers Through IT Excellence");
        heroContent.setSubtitle(
                "C-DAC ACTS authorized training center in Mumbai — courses for all age groups from 3+ to senior citizens");
        return heroContent;
    }
}

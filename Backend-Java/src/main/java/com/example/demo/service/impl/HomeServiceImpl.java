package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.response.BannerResponse;
import com.example.demo.dto.response.CourseResponse;
import com.example.demo.dto.response.HomeResponse;
import com.example.demo.entity.Banner;
import com.example.demo.entity.Course;
import com.example.demo.repository.BannerRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.intf.HomeService;

import com.example.demo.dto.response.TestimonialResponse;
import com.example.demo.entity.Testimonial;
import com.example.demo.repository.TestimonialRepository;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private BannerRepository bannerRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private TestimonialRepository testimonialRepository;

	@Override
	public HomeResponse getHomePage() {

		HomeResponse response = new HomeResponse();

		// ---------------- Banner ----------------
		List<Banner> banners = bannerRepository.findByIsActiveTrueOrderByDisplayOrderAsc();

		if (!banners.isEmpty()) {

			Banner banner = banners.get(0);

			BannerResponse bannerResponse = new BannerResponse();
			bannerResponse.setTitle(banner.getTitle());
			bannerResponse.setSubtitle("");
			bannerResponse.setImageUrl(banner.getImageUrl());

			response.setBanner(bannerResponse);
		}

		// ---------------- Courses ----------------
		List<Course> courses = courseRepository.findByIsActiveTrue();

		List<CourseResponse> courseResponseList = new ArrayList<>();

		for (Course course : courses) {

			CourseResponse courseResponse = new CourseResponse();

			courseResponse.setCourseId(course.getCourseId());
			courseResponse.setName(course.getName());

			courseResponseList.add(courseResponse);
		}

		response.setCourses(courseResponseList);
		List<Testimonial> testimonials = testimonialRepository.findByIsApprovedTrue();

		List<TestimonialResponse> testimonialResponseList = new ArrayList<>();

		for (Testimonial testimonial : testimonials) {

			TestimonialResponse testimonialResponse = new TestimonialResponse();

			testimonialResponse.setName(testimonial.getName());
			testimonialResponse.setContent(testimonial.getContent());
			testimonialResponse.setRating(testimonial.getRating());
			testimonialResponse.setPhotoUrl(testimonial.getPhotoUrl());

			testimonialResponseList.add(testimonialResponse);
		}

		response.setTestimonials(testimonialResponseList);

		return response;
	}
}
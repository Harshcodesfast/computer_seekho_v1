package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.EnquiryRequest;
import com.example.demo.dto.response.EnquiryResponse;
import com.example.demo.dto.response.HomeResponse;
import com.example.demo.service.intrf.HomeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/home")
@CrossOrigin(origins = "http://localhost:5173")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public ResponseEntity<HomeResponse> getHomePage() {
        return ResponseEntity.ok(homeService.getHomePage());
    }

    @PostMapping("/enquire")
    public ResponseEntity<EnquiryResponse> submitEnquiry(@Valid @RequestBody EnquiryRequest request) {
        EnquiryResponse response = homeService.submitEnquiry(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

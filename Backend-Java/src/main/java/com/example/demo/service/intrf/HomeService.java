package com.example.demo.service.intrf;

import com.example.demo.dto.request.EnquiryRequest;
import com.example.demo.dto.response.EnquiryResponse;
import com.example.demo.dto.response.HomeResponse;

public interface HomeService {

    HomeResponse getHomePage();

    EnquiryResponse submitEnquiry(EnquiryRequest request);
}

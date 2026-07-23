package com.example.demo.dto.request;

import com.example.demo.entity.Inquiry.InquiryStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloseInquiryRequestDTO {

    private InquiryStatus status;

    private String reasonForClosure;

}
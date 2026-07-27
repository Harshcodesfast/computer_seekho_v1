package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnquiryRequest {

    @NotBlank
    @Size(max = 150)
    private String enquirerName;

    @Email
    @Size(max = 150)
    private String email;

    @Size(max = 15)
    private String phone;

    @Size(max = 1000)
    private String message;

    @NotNull
    private Integer courseId;
}

package com.example.demo.dto.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {

    private Integer courseId;
    private String name;
    private String description;
    private String duration;
    private BigDecimal fees;
    private String coverPhoto;
    private String categoryName;
    private String level;
}

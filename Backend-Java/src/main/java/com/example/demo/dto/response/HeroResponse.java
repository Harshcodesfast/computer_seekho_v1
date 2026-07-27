package com.example.demo.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroResponse {

    private String title;
    private String subtitle;
    private List<HeroHighlightResponse> highlights;
}

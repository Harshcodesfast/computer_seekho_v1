package com.example.demo.dto.request;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowupUpdateRequestDTO {
		private String notes;

	    private String specialInstructions;

	    private LocalDate nextFollowup;

}

package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.response.FollowupDashboardDTO;
import com.example.demo.entity.FollowUp;
import com.example.demo.entity.Student;

@Component
public class FollowupMapper {

    public FollowupDashboardDTO toDTO(FollowUp followUp) {

        FollowupDashboardDTO dto = new FollowupDashboardDTO();

        // Enquiry ID
        dto.setEnquiryId(
                followUp.getInquiry().getInquiryId());

        // Enquirer Name
        dto.setEnquirerName(
                followUp.getInquiry().getEnquirerName());

        // Phone
        dto.setPhone(
                followUp.getInquiry().getPhone());

        // Course Name
        dto.setCourse(
                followUp.getInquiry()
                        .getCourse()
                        .getName());

        // Follow-up Date
        dto.setFollowupDate(
                followUp.getFollowupDate());

        // Staff Name
        dto.setStaffName(
                followUp.getStaff()
                        .getName());

        // Student Name
        Student student = followUp.getInquiry().getStudent();

        if (student != null) {

            dto.setStudentName(
                    student.getFirstName()
                    + " "
                    + student.getLastName());

        } else {

            dto.setStudentName("-");

        }

        return dto;
    }

}
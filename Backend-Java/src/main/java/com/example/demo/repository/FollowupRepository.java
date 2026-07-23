package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FollowUp;

import com.example.demo.entity.Inquiry;

@Repository
public interface FollowupRepository extends JpaRepository<FollowUp, Integer> {

    @EntityGraph(attributePaths = {
            "inquiry",
            "inquiry.course",
            "inquiry.student",
            "staff"
    })
    List<FollowUp> findByInquiryStatusOrderByFollowupDateAsc(
            Inquiry.InquiryStatus status);
    List<FollowUp> findAllByOrderByFollowupDateAsc();

    List<FollowUp> findByStaffStaffIdOrderByFollowupDateAsc(Integer staffId);


    List<FollowUp> findByFollowupDateOrderByFollowupDateAsc(LocalDate followupDate);

}
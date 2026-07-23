package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.FollowupUpdateRequestDTO;
import com.example.demo.dto.response.FollowupDashboardDTO;
import com.example.demo.entity.FollowUp;
import com.example.demo.entity.Inquiry;
import com.example.demo.mapper.FollowupMapper;
import com.example.demo.repository.FollowupRepository;
import com.example.demo.service.intrf.FollowupService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FollowupServiceImpl implements FollowupService {

    private final FollowupRepository followupRepository;
    private final FollowupMapper followupMapper;

    public FollowupServiceImpl(FollowupRepository followupRepository,
                               FollowupMapper followupMapper) {

        this.followupRepository = followupRepository;
        this.followupMapper = followupMapper;
    }
    
    @Override
    public void updateFollowup(Integer followupId,
                               FollowupUpdateRequestDTO request) {

        FollowUp followUp = followupRepository
                .findById(followupId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Follow-up not found"));

        followUp.setNotes(request.getNotes());

        followUp.setSpecialInstructions(
                request.getSpecialInstructions());

        followUp.setNextFollowup(
                request.getNextFollowup());

        followupRepository.save(followUp);
    }

   /* @Override
    public List<FollowupDashboardDTO> getPendingFollowups() {

        List<FollowUp> followUps =
                followupRepository
                        .findByInquiryStatusOrderByFollowupDateAsc(
                                Inquiry.InquiryStatus.In_Followup);

        return followUps.stream()
                .map(followupMapper::toDTO)
                .collect(Collectors.toList());
    }*/
    @Override
    public List<FollowupDashboardDTO> getAllFollowups() {

        return followupRepository
                .findAllByOrderByFollowupDateAsc()
                .stream()
                .map(followupMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<FollowupDashboardDTO> getFollowupsByStaff(Integer staffId) {

        return followupRepository
                .findByStaffStaffIdOrderByFollowupDateAsc(staffId)
                .stream()
                .map(followupMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<FollowupDashboardDTO> getTodayFollowups() {

        return followupRepository
                .findByFollowupDateOrderByFollowupDateAsc(java.time.LocalDate.now())
                .stream()
                .map(followupMapper::toDTO)
                .collect(Collectors.toList());
    }
    
}
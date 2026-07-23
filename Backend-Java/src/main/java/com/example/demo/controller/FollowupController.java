package com.example.demo.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.FollowupUpdateRequestDTO;
import com.example.demo.dto.response.FollowupDashboardDTO;
import com.example.demo.service.intrf.FollowupService;

@RestController
@RequestMapping("/api/followups")
@CrossOrigin(origins = "http://localhost:5173")
public class FollowupController {

    private final FollowupService followupService;

    public FollowupController(FollowupService followupService) {
        this.followupService = followupService;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFollowup(
            @PathVariable Integer id,
            @RequestBody FollowupUpdateRequestDTO request) {

        followupService.updateFollowup(id, request);

        return ResponseEntity.ok("Follow-up updated successfully");
    }

    /*@GetMapping("/dashboard")
    public ResponseEntity<List<FollowupDashboardDTO>> getPendingFollowups() {

        List<FollowupDashboardDTO> response =
                followupService.getPendingFollowups();

        return ResponseEntity.ok(response);
    }*/
    
    @GetMapping
    public ResponseEntity<List<FollowupDashboardDTO>> getAllFollowups() {

        return ResponseEntity.ok(
                followupService.getAllFollowups());
    }
    
    @GetMapping("/staff/{staffId}")
    public ResponseEntity<List<FollowupDashboardDTO>> getByStaff(
            @PathVariable Integer staffId) {

        return ResponseEntity.ok(
                followupService.getFollowupsByStaff(staffId));
    }
    
    @GetMapping("/today")
    public ResponseEntity<List<FollowupDashboardDTO>> getToday() {

        return ResponseEntity.ok(
                followupService.getTodayFollowups());
    }

}
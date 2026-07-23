package com.example.demo.service.intrf;

import java.util.List;

import com.example.demo.dto.request.FollowupUpdateRequestDTO;
import com.example.demo.dto.response.FollowupDashboardDTO;

public interface FollowupService {

    //List<FollowupDashboardDTO> getPendingFollowups();
    List<FollowupDashboardDTO> getAllFollowups();

    List<FollowupDashboardDTO> getFollowupsByStaff(Integer staffId);

    List<FollowupDashboardDTO> getTodayFollowups();
    void updateFollowup(Integer followupId,
            FollowupUpdateRequestDTO request);
}

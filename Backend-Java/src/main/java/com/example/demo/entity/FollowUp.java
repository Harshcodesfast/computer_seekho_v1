package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "followups")
@Getter
@Setter
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followup_id")
    private Integer followupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id", nullable = false)
    private Inquiry inquiry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Column(name = "followup_date", nullable = false)
    private LocalDate followupDate = LocalDate.now();

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "next_followup")
    private LocalDate nextFollowup;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FollowUpStatus status = FollowUpStatus.Pending;

    public enum FollowUpStatus {
        Pending,
        Done,
        No_Response
    }
}

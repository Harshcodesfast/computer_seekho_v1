package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "inquiries")
@Getter
@Setter
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private Integer inquiryId;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    
    @Column(name = "enquirer_name", nullable = false, length = 150)
    private String enquirerName;
    

    @Column(name = "email", length = 150)
    private String email;
    

    @Column(name = "phone", length = 15)
    private String phone;
    

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;
    

    @Column(name = "source", length = 100)
    private String source;
    

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryStatus status = InquiryStatus.New;

    @Column(name = "inquiry_date", nullable = false)
    private LocalDate inquiryDate = LocalDate.now();

    public enum InquiryStatus {
        New,
        In_Followup,
        Converted,
        Lost,
        Not_Interested
    }
}

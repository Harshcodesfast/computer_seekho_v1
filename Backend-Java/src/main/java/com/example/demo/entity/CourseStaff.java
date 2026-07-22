package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(
    name = "course_staff",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_course_staff", columnNames = {"course_id", "staff_id"})
    }
)
@Getter
@Setter
public class CourseStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_staff_id")
    private Integer courseStaffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Column(name = "assigned_date")
    private LocalDate assignedDate = LocalDate.now();

    @Column(name = "is_primary")
    private Boolean isPrimary = false;
}
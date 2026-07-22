package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CourseCategory category;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 50)
    private String duration;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal fees = BigDecimal.ZERO;

    @Column(name = "course_fees_from")
    private LocalDate courseFeesFrom;

    @Column(name = "course_fees_to")
    private LocalDate courseFeesTo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Level level = Level.Beginner;

    @Column(name = "syllabus_url", length = 500)
    private String syllabusUrl;

    @Column(name = "cover_photo", length = 255)
    private String coverPhoto;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public enum Level { Beginner, Intermediate, Advanced }
}
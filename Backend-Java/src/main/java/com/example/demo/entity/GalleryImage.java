package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "gallery_images")
@Getter
@Setter
public class GalleryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;

    @Column(length = 100)
    private String category;

    @Column(name = "upload_date", nullable = false)
    private LocalDate uploadDate = LocalDate.now();

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
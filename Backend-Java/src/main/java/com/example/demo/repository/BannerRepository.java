package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {

    List<Banner> findByIsActiveTrueOrderByDisplayOrderAsc();

}
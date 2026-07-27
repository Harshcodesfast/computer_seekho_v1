package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NewsEvent;

@Repository
public interface NewsEventRepository extends JpaRepository<NewsEvent, Integer> {

    List<NewsEvent> findByIsActiveTrueOrderByCreatedAtDesc();
}

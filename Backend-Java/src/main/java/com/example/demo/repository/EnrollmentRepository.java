
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    List<Enrollment> findByStudentStudentId(Integer studentId);

    List<Enrollment> findByBatchBatchId(Integer batchId);

    List<Enrollment> findByInquiryInquiryId(Integer inquiryId);

    List<Enrollment> findByStatus(Enrollment.EnrollmentStatus status);

}
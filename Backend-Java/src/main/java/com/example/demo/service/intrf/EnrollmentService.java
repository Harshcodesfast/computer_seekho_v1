package com.example.demo.service.intrf;

import java.util.List;

import com.example.demo.entity.Enrollment;

public interface EnrollmentService {

    Enrollment saveEnrollment(Enrollment enrollment);

    List<Enrollment> getAllEnrollments();

    Enrollment getEnrollmentById(Integer enrollmentId);

    Enrollment updateEnrollment(Integer enrollmentId, Enrollment enrollment);

    void deleteEnrollment(Integer enrollmentId);

    List<Enrollment> getEnrollmentByStudent(Integer studentId);

    List<Enrollment> getEnrollmentByBatch(Integer batchId);

    List<Enrollment> getEnrollmentByInquiry(Integer inquiryId);

    List<Enrollment> getEnrollmentByStatus(Enrollment.EnrollmentStatus status);

}
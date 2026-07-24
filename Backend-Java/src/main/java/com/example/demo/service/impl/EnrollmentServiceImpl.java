package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Enrollment;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.service.intrf.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Integer enrollmentId) {
        return enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    @Override
    public Enrollment updateEnrollment(Integer enrollmentId, Enrollment enrollment) {

        Enrollment existing = getEnrollmentById(enrollmentId);

        existing.setStudent(enrollment.getStudent());
        existing.setBatch(enrollment.getBatch());
        existing.setInquiry(enrollment.getInquiry());
        existing.setEnrollDate(enrollment.getEnrollDate());
        existing.setStatus(enrollment.getStatus());

        return enrollmentRepository.save(existing);
    }

    @Override
    public void deleteEnrollment(Integer enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }

    @Override
    public List<Enrollment> getEnrollmentByStudent(Integer studentId) {
        return enrollmentRepository.findByStudentStudentId(studentId);
    }

    @Override
    public List<Enrollment> getEnrollmentByBatch(Integer batchId) {
        return enrollmentRepository.findByBatchBatchId(batchId);
    }

    @Override
    public List<Enrollment> getEnrollmentByInquiry(Integer inquiryId) {
        return enrollmentRepository.findByInquiryInquiryId(inquiryId);
    }

    @Override
    public List<Enrollment> getEnrollmentByStatus(Enrollment.EnrollmentStatus status) {
        return enrollmentRepository.findByStatus(status);
    }
}
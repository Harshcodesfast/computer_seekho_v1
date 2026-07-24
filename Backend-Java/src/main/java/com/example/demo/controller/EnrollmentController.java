package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Enrollment;
import com.example.demo.service.intrf.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
@CrossOrigin("*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment saveEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.saveEnrollment(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable Integer id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Integer id,
                                       @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Integer id) {
        enrollmentService.deleteEnrollment(id);
        return "Enrollment deleted successfully";
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getByStudent(@PathVariable Integer studentId) {
        return enrollmentService.getEnrollmentByStudent(studentId);
    }

    @GetMapping("/batch/{batchId}")
    public List<Enrollment> getByBatch(@PathVariable Integer batchId) {
        return enrollmentService.getEnrollmentByBatch(batchId);
    }

    @GetMapping("/inquiry/{inquiryId}")
    public List<Enrollment> getByInquiry(@PathVariable Integer inquiryId) {
        return enrollmentService.getEnrollmentByInquiry(inquiryId);
    }

    @GetMapping("/status/{status}")
    public List<Enrollment> getByStatus(@PathVariable Enrollment.EnrollmentStatus status) {
        return enrollmentService.getEnrollmentByStatus(status);
    }
}
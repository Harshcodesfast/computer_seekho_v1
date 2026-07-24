package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.intrf.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudent(Integer studentId, Student student) {

        Student existingStudent = studentRepository.findById(studentId).orElse(null);

        if (existingStudent != null) {

            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setParentName(student.getParentName());
            existingStudent.setParentPhone(student.getParentPhone());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhone(student.getPhone());
            existingStudent.setDob(student.getDob());
            existingStudent.setGender(student.getGender());
            existingStudent.setAddressLine1(student.getAddressLine1());
            existingStudent.setAddressLine2(student.getAddressLine2());
            existingStudent.setCity(student.getCity());
            existingStudent.setState(student.getState());
            existingStudent.setPincode(student.getPincode());
            existingStudent.setPhotoUrl(student.getPhotoUrl());
            existingStudent.setQualification(student.getQualification());
            existingStudent.setInquiry(student.getInquiry());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Student getStudentByPhone(String phone) {
        return studentRepository.findByPhone(phone).orElse(null);
    }

    @Override
    public List<Student> searchStudentByFirstName(String firstName) {
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName);
    }
}
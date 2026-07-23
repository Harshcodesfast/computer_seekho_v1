package com.example.demo.service.intrf;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    Student updateStudent(Integer studentId, Student student);

    void deleteStudent(Integer studentId);

    Student getStudentByEmail(String email);

    Student getStudentByPhone(String phone);

    List<Student> searchStudentByFirstName(String firstName);
}
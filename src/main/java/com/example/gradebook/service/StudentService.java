package com.example.gradebook.service;

import com.example.datainit.StudentDTO;
import com.example.gradebook.entity.Student;

import java.util.List;

public interface StudentService {
    Student findById(int id);

    void deleteById(int id);

    void addGrade(int id, int grade);

    void addStudent(StudentDTO student);

    List<Student> findAll();

    void addGroupToStudent(int id, int groupId);

    List<Student> getTopFiveStudents();
}


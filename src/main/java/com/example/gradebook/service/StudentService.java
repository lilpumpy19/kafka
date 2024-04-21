package com.example.gradebook.service;

import com.example.gradebook.dto.StudentDTO;
import com.example.gradebook.entity.Student;

public interface StudentService {
    Student findById(int id);

    void deleteById(int id);

    void addGrade(int id, int grade);

    void addStudent(StudentDTO student);
}


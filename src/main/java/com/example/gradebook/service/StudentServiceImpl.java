package com.example.gradebook.service;

import com.example.gradebook.dto.StudentDTO;
import com.example.gradebook.entity.Student;
import com.example.gradebook.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void addGrade(int id, int grade) {

    }

    @Override
    public void addStudent(StudentDTO student) {
        studentRepository.save(new Student(student.getName(), student.getSurname()));
    }


}

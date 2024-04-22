package com.example.gradebook.service;

import com.example.gradebook.dto.StudentDTO;
import com.example.gradebook.entity.Student;
import com.example.gradebook.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student findById(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        studentRepository.deleteById(id);
    }

    @Override
    public void addGrade(int id, int grade) {
        Student student = findById(id);
        student.addGrade(grade);
        studentRepository.save(student);
    }

    @Override
    public void addStudent(StudentDTO student) {
        studentRepository.save(new Student(student.getName(), student.getSurname()));
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


}

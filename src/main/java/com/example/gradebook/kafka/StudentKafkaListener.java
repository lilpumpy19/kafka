//package com.example.gradebook.kafka;
//
//
//import com.example.gradebook.dto.StudentDTO;
//import com.example.gradebook.service.StudentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class StudentKafkaListener {
//    private final StudentService studentService;
//
//    @KafkaListener(topics = {"students"})
//    public void studentsListener(StudentDTO studentDTO) {
//        studentService.addStudent(studentDTO);
//    }
//
//}

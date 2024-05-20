package com.example.gradebook.kafka;


import com.example.datainit.StudentDTO;
import com.example.gradebook.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentKafkaListener {
    private final StudentService studentService;

    @KafkaListener(topics = "${spring.kafka.topic.studentsTopic}",
    groupId = "${spring.kafka.groupStudentId}",
    containerFactory = "studentKafkaListenerContainerFactory")
    public void studentsListener(StudentDTO studentDTO) {
        System.out.println("studentsListener");
        studentService.addStudent(studentDTO);
    }

}

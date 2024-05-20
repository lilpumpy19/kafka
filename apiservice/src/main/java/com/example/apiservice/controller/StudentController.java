package com.example.apiservice.controller;

import com.example.datainit.Student;
import com.example.datainit.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/kafka/student/api")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private KafkaTemplate<String, StudentDTO> kafkaTemplate;
    @Value("${kafka.topic.studentsTopic}")
    private String studentsTopic;

    private String url = "http://localhost:8080/api/student/";

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println(studentDTO.getName() + " " + studentDTO.getSurname());
        kafkaTemplate.send(studentsTopic, studentDTO);
        return ResponseEntity.ok("Student added successfully");
    }

    @GetMapping("/getTopFiveStudents")
    public ResponseEntity<List<Student>> getTopFiveStudents() {
        ResponseEntity<List<Student>> response = new RestTemplate().exchange(url + "getTopFiveStudents",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});
        return response;
    }



}

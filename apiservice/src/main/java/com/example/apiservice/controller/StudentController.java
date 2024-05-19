package com.example.apiservice.controller;

import com.example.apiservice.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/kafka/student/api")
@RequiredArgsConstructor
public class StudentController {
    private KafkaTemplate<String, StudentDTO> kafkaTemplate;
    private RestTemplate restTemplate;
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;
    @Value("${spring.kafka.studentsTopic}")
    private String dataServiceUrl;
    @Value("${data-service.base-url}")
    private String studentsTopic;

    private String url = "http://localhost:8080/api/student/";

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(StudentDTO studentDTO) {
        kafkaTemplate.send(studentsTopic, studentDTO);
        return ResponseEntity.ok("Student added successfully");
    }



}

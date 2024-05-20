package com.example.apiservice.controller;

import com.example.datainit.Group;
import com.example.datainit.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/kafka/group/api")
@RequiredArgsConstructor
public class GroupController {
    @Autowired
    private KafkaTemplate<String, StudentDTO> kafkaTemplate;
    @Value("${kafka.topic.studentsTopic}")
    private String studentsTopic;
    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8080/api/group/";

    @GetMapping("/getTopTreeGroupsByStudentsCount")
    public ResponseEntity<List<Group>> getTopTreeGroupsByStudentsCount() {
        ResponseEntity<List<Group>> response = restTemplate.exchange(url + "getTopTreeGroupsByStudentsCount",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Group>>() {});
        return response;
    }
}

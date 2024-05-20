package com.example.gradebook.controller;

import com.example.datainit.StudentDTO;
import com.example.gradebook.entity.Student;
import com.example.gradebook.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents() {
        System.out.println("getAllStudents");
        try {
            return ResponseEntity.ok(studentService.findAll());
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping("/getStudentById")
    public ResponseEntity<?> getStudentById(@RequestParam int id) {
        System.out.println("getStudentById");
        try {
            return ResponseEntity.ok(studentService.findById(id));
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }
    @DeleteMapping("/deleteStudentById")
    public ResponseEntity<?> deleteStudentById(@RequestParam int id) {
        System.out.println("deleteStudentById");
        try {
            studentService.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @PostMapping("/addGrade")
    public ResponseEntity<?> addGrade(@RequestParam int id, @RequestParam int grade) {
        System.out.println("addGrade");
        try {
            studentService.addGrade(id, grade);
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }
    @PutMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO student) {
        System.out.println("addStudent");
        try {
            studentService.addStudent(student);
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/addGroupToStudent")
    public ResponseEntity<?> addGroupToStudent(@RequestParam int id, @RequestParam int groupId) {
        System.out.println("addGroupToStudent");
        try {
            studentService.addGroupToStudent(id, groupId);
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/getTopFiveStudents")
    public ResponseEntity<?> getTopFiveStudents() {
        System.out.println("getTopFiveStudents");
        try {
            return ResponseEntity.ok(studentService.getTopFiveStudents());
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}

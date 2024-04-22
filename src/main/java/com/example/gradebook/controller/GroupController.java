package com.example.gradebook.controller;

import com.example.gradebook.dto.GroupDTO;
import com.example.gradebook.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {
    private final GroupService groupService;

    @GetMapping("/getAllGroups")
    public ResponseEntity<?> getAllGroups() {
        try {
            return ResponseEntity.ok(groupService.findAll());
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/getGroupById")
    public ResponseEntity<?> getGroupById(@RequestParam int id) {
        try {
            return ResponseEntity.ok(groupService.findById(id));
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @PutMapping("/addGroup")
    public ResponseEntity<?> addGroup(@RequestBody GroupDTO group) {
        try {
            groupService.addGroup(group);
            return ResponseEntity.ok().build();
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @GetMapping("/getStudentsByGroupId")
    public ResponseEntity<?> getStudentsByGroupId(@RequestParam int id) {
        try {
            return ResponseEntity.ok(groupService.getStudentsByGroupId(id));
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}

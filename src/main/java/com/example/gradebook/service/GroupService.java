package com.example.gradebook.service;

import com.example.gradebook.dto.GroupDTO;
import com.example.gradebook.entity.Group;
import com.example.gradebook.entity.Student;

import java.util.List;

public interface GroupService {

    Group findById(int id);

    void addGroup(GroupDTO group);

    List<Group> findAll();

    List<Student> getStudentsByGroupId(int id);

    List<Group> getTopTreeGroupsByStudentsCount();

    void deleteById(int id);
}

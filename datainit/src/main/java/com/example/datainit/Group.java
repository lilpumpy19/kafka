package com.example.datainit;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;


@RequiredArgsConstructor
@Data
@ToString
public class Group {

    private int id;

    private String name;

    private List<Student> students;

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

}

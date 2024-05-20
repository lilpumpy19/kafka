package com.example.datainit;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;


@RequiredArgsConstructor
@Data
@ToString
public class Student {

    private int id;


    private String name;

    private String surname;

    private Group group;

    private List<Integer> grades;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }


}

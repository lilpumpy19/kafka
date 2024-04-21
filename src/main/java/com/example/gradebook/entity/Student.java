package com.example.gradebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "students")
@RequiredArgsConstructor
@Data
@ToString
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @JoinColumn(name = "group_id")
    @ManyToOne
    private Group group;

    @ElementCollection
    @CollectionTable(name = "student_grades", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "grades")
    private List<Integer> grades;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

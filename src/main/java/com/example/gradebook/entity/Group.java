package com.example.gradebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
@Entity
@Table(name = "groups")
@RequiredArgsConstructor
@Data
@ToString
public class Group {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;

    public void addStudent(Student student) {
        this.students.add(student);
    }
}

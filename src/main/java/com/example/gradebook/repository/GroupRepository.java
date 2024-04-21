package com.example.gradebook.repository;

import com.example.gradebook.entity.Group;
import com.example.gradebook.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {



}

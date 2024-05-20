package com.example.gradebook.service;

import com.example.gradebook.dto.GroupDTO;

import com.example.gradebook.entity.Group;
import com.example.gradebook.entity.Student;
import com.example.gradebook.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByGroupId(int id) {
        Group group = findById(id);
        return group.getStudents();
    }


    @Override
    public Group findById(int id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElseThrow(() -> new RuntimeException("Group with ID " + id + " not found"));
    }

    @Override
    public void addGroup(GroupDTO group) {
        groupRepository.save(new Group(group.getName()));
    }

    @Override
    public List<Group> getTopTreeGroupsByStudentsCount() {
        List<Group> groups = findAll();
        groups.sort((g1, g2) -> g2.getStudents().size() - g1.getStudents().size());
        return groups.subList(0, 3);
    }

    @Override
    public void deleteById(int id) {
        if (!groupRepository.existsById(id)) {
            throw new RuntimeException("Group with ID " + id + " not found");
        }else {
            groupRepository.deleteById(id);
        }

    }


}

package com.example.demo.controller;

import com.example.demo.model.Classroom;
import com.example.demo.repository.IClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/classrooms")
@RequiredArgsConstructor
public class ClassroomController {
    @Autowired
    private final IClassroomRepository classroomRepository;

    @GetMapping
    public List<Classroom> findAllClassrooms() {
        return classroomRepository.findAll();
    }
}

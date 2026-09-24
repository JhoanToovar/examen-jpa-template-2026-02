package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {
    @Autowired
    private final IPullRequestRepository pullRequestRepository;

    @GetMapping
    public List<PullRequest> findAllPullRequests() {
        return pullRequestRepository.findAll();
    }

    @GetMapping("/e1")
    public List<PullRequest> e1(){
        return pullRequestRepository.findByReviewer_Classrooms_NameAndStatusOrderByCreatedAtDesc("Computacion en Internet II - Grupo 1", "OPEN");
    }

    @GetMapping("/e3")
    public List<PullRequest> e3(){
        return pullRequestRepository.findByReviewer_RoleEqualsAndOwner_UsernameEqualsAndRepository_Assignment_Classroom_SemesterEquals("TA", "cjimenez", "2026-02");
    }
}

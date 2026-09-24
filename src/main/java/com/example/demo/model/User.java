package com.example.demo.model;


import lombok.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name ="id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<PullRequest> ownedRepositories;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<PullRequest> authoredPullRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "reviewer")
    private List<PullRequest> reviewedPullRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Commit> commits;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Classroom> classrooms;
}

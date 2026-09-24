package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;

import java.security.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @Column(name ="id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "is_template", nullable = false)
    private Boolean isTemplate;


    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "parent_repo_id")
    private Repository parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    private List<Repository> repositories;


}

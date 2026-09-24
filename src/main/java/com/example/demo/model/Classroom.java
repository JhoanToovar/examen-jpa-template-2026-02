package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @Column(name ="id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "course_code",nullable = false)
    private String courseCode;

    @Column(name="semester")
    private String semester;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToMany(mappedBy = "classroom")
    @JsonIgnore
    private List<Assignment> assignments;

}

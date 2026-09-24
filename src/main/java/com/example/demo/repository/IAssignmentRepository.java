package com.example.demo.repository;

import com.example.demo.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByClassroom_TeacherNameEqualsAndRepositories_Pullrequests_Reviewer_NameEqualsAndRepositories_Pullrequests_Status(String classroom_TeacherName, String repositories_Pullrequests_Reviewer_Name, String status);

}

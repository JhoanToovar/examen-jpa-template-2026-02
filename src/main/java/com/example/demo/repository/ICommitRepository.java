package com.example.demo.repository;

import com.example.demo.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommitRepository extends JpaRepository<Commit, Long> {

    List<Commit> findByRepository_NameContainingAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(String repository_name, String message, Integer lines_added);
}

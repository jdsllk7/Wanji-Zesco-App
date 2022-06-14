package com.telusko.demo.repository;

import com.telusko.demo.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
    List<Issue> findAll();
    Issue findFirstById(Integer id);
}

package com.Async.demo.Repositary;

import com.Async.demo.Entity.Questions_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepositray extends JpaRepository<Questions_model,Integer> {
Questions_model findBycategory(String questionTitle);

@Query(value = "SELECT * FROM Questions_model Q WHERE Q.category=:category ORDER BY random() LIMIT:noOfQuestion ",nativeQuery = true)
    List<Questions_model> findRandomQuestionBycategory(String category, int noOfQuestion);
}

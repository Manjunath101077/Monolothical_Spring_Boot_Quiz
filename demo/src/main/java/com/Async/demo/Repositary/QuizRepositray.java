package com.Async.demo.Repositary;

import com.Async.demo.Entity.Quiz_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepositray extends JpaRepository<Quiz_model,Integer> {
}

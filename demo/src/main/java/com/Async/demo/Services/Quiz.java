package com.Async.demo.Services;

import com.Async.demo.Entity.QuestionWrapper;
import com.Async.demo.Entity.Quiz_model;
import com.Async.demo.Entity.ResponseAns;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Quiz {
    void createQuiz(String category, int numQ, String title);


    List<QuestionWrapper> getQuizQuestion(Integer id);

    ResponseEntity<Integer> calculateTheResult(Integer id, List<ResponseAns> responseAns);
}

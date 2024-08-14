package com.Async.demo.Controllers;

import com.Async.demo.Entity.QuestionWrapper;
import com.Async.demo.Entity.Quiz_model;
import com.Async.demo.Entity.ResponseAns;
import com.Async.demo.Services.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizControllers {
    @Autowired
    Quiz quizservice;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){

        quizservice.createQuiz(category,numQ,title);
        return new ResponseEntity<>("Created",HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public List<QuestionWrapper> getQuizQuestion(@PathVariable Integer id){

        return quizservice.getQuizQuestion(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<ResponseAns> responseAns)
    {
        return quizservice.calculateTheResult(id,responseAns);
    }
}

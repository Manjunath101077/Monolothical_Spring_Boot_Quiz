package com.Async.demo.Controllers;

import com.Async.demo.Entity.Questions_model;
import com.Async.demo.Repositary.QuestionRepositray;
import com.Async.demo.Services.Questionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionControllers {
    @Autowired
    Questionservice questionservice;

    @GetMapping(path = "allQuestions")

    public ResponseEntity<List<Questions_model>> getQuestionList(){
        return new ResponseEntity<>(questionservice.getQuestion(), HttpStatus.OK);
    }

    @GetMapping(path = "/getQuestion/{questionTitle}")
    public ResponseEntity<Questions_model> getQuestionByCategory(@PathVariable String questionTitle){
        return new ResponseEntity<>(questionservice.getQuestionBYCategory(questionTitle),HttpStatus.OK);
    }



    @PostMapping (path = "/postingQuestions")
    public ResponseEntity<String> postingQuestion(@RequestBody Questions_model questionsModel){
                questionservice.postingQuestion(questionsModel);
        return new ResponseEntity<>("Sucees",HttpStatus.CREATED);
    }
}

package com.Async.demo.Services;

import com.Async.demo.Entity.Questions_model;
import com.Async.demo.Repositary.QuestionRepositray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Questionservice implements QuestionList{
    @Autowired
QuestionRepositray questionRepositray;
    public List<Questions_model> getQuestion() {
        return questionRepositray.findAll();
    }

    public void postingQuestion(Questions_model questionsModel) {
        questionRepositray.save(questionsModel);
    }

    public Questions_model getQuestionBYCategory(String questionTitle) {
    Questions_model questionsModel=questionRepositray.findBycategory(questionTitle);
    return questionsModel;
    }



}

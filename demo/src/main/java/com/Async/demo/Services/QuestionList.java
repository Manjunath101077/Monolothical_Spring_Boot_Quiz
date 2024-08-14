package com.Async.demo.Services;

import com.Async.demo.Entity.Questions_model;

import java.util.List;

public interface QuestionList {
    public List<Questions_model> getQuestion();
    public void postingQuestion(Questions_model questionsModel);
    public Questions_model getQuestionBYCategory(String questionTitle);


}

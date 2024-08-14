package com.Async.demo.Services;

import com.Async.demo.Entity.QuestionWrapper;
import com.Async.demo.Entity.Questions_model;
import com.Async.demo.Entity.Quiz_model;
import com.Async.demo.Entity.ResponseAns;
import com.Async.demo.Repositary.QuestionRepositray;
import com.Async.demo.Repositary.QuizRepositray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Quiz_Service implements Quiz{

    @Autowired
    QuestionRepositray questionRepositray;
    @Autowired
    QuizRepositray quizRepositray;

    @Override
    public void createQuiz(String category, int numQ, String title){
        List<Questions_model> listOfQuestion=questionRepositray.findRandomQuestionBycategory(category,numQ);
    Quiz_model quizModel=new Quiz_model();
    quizModel.setTitle(title);
    quizModel.setQuestionsModels(listOfQuestion);
    quizRepositray.save(quizModel);
    }

    @Override
    public List<QuestionWrapper> getQuizQuestion(Integer id) {
        Optional<Quiz_model> quizModel=quizRepositray.findById(id);
        List<Questions_model> questionsModel=quizModel.get().getQuestionsModels();
        List<QuestionWrapper> getThqQuestion=new ArrayList<>();
        for(Questions_model questions : questionsModel){
            QuestionWrapper questionWrapper=new QuestionWrapper(questions.getId(),questions.getQuestionTitle(),questions.getOption1(),questions.getOption2(),questions.getOption3(),questions.getOption4());
            getThqQuestion.add(questionWrapper);
        }
        return getThqQuestion;
    }

    @Override
    public ResponseEntity<Integer> calculateTheResult(Integer id, List<ResponseAns> responseAns) {
        Quiz_model quizModel=quizRepositray.findById(id).get();
        List<Questions_model> questionsModels=quizModel.getQuestionsModels();
        int right=0;
        int i=0;
        for(ResponseAns response: responseAns)
            if(response.getResponse().equals(questionsModels.get(i).getRightAnswer())){
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }


}

package com.QuizApi.controller;

import com.QuizApi.model.Question;
import com.QuizApi.model.QuestionWrapper;
import com.QuizApi.model.Response;
import com.QuizApi.service.QuestionService;
import com.QuizApi.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    //http://localhost:8080/quiz/create?category=java&num=5&title=Quiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int num,@RequestParam String title){

        return quizService.createQuiz(category,num,title);
    }

    //http://localhost:8080/quiz/get/1
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long id){

        return quizService.getQuizQuestions(id);

    }

    //http://localhost:8080/quiz/submit/1
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses){

        return quizService.calculatrResult(id ,responses);

    }
}

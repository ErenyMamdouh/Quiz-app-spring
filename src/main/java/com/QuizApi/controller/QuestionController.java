package com.QuizApi.controller;

import com.QuizApi.model.Question;
import com.QuizApi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/")
public class QuestionController {

    @Autowired
    QuestionService  questionService;

    //http://localhost:8080/question/AllQuestions
    @GetMapping("AllQuestions")
    public ResponseEntity<List<Question>>getAllQuestion(){

        return questionService.getAllQuestion();
    }

    //http://localhost:8080/question/category?category=java
    @GetMapping("category")
    public ResponseEntity<List<Question>> getQuestionByCategory(@RequestParam String category){
        return questionService.getQuestionByCategory(category);
    }

    //http://localhost:8080/question/add
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

   //http://localhost:8080/question/delete?id=
    @DeleteMapping("delete")
    public void deleteQuestion(@RequestParam Long id){
         questionService.deleteQuestion(id);
    }

    //http://localhost:8080/question/update?category=
    @PutMapping("update")
    public Question editeQuestion(@RequestBody Question question,@RequestParam String category){
        question.setCategory(category);
        return questionService.editeQuestion(question,category);

    }

}

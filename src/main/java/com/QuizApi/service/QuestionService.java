package com.QuizApi.service;

import com.QuizApi.model.Question;
import com.QuizApi.doa.QuestionDoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDoa questionDoa;
    public ResponseEntity<List<Question>> getAllQuestion() {

        try {
            return new ResponseEntity<List<Question>>(questionDoa.findAll() ,HttpStatus.OK) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<List<Question>> getQuestionByCategory( String category) {
        try {
            return new ResponseEntity<>(questionDoa.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> addQuestion(Question question) {
         questionDoa.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public void deleteQuestion(Long id){
        questionDoa.deleteById(id);
    }

    public Question editeQuestion(Question question, String category) {
        return questionDoa.save(question);
    }
}


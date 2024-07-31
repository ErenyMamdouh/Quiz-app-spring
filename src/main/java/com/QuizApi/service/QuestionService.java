package com.QuizApi.service;

import com.QuizApi.model.Question;
import com.QuizApi.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestion() {

        try {
            return new ResponseEntity<List<Question>>(questionDao.findAll() ,HttpStatus.OK) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<List<Question>> getQuestionByCategory( String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> addQuestion(Question question) {
         questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public void deleteQuestion(Long id){
        questionDao.deleteById(id);
    }

    public Question editeQuestion(Question question, String category) {
        return questionDao.save(question);
    }
}


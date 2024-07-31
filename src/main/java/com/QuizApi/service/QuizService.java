package com.QuizApi.service;

import com.QuizApi.dao.QuestionDao;
import com.QuizApi.dao.QuizDao;
import com.QuizApi.model.Question;
import com.QuizApi.model.QuestionWrapper;
import com.QuizApi.model.Quiz;
import com.QuizApi.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int num, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, num);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success",HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long id) {
        Optional<Quiz> quiz= quizDao.findById(id);
        List<Question> questionFromDB= quiz.get().getQuestion();
        List<QuestionWrapper> questionFprmUser = new ArrayList<>();
        for(Question q: questionFromDB ){
            QuestionWrapper QW = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());

            questionFprmUser.add(QW);
        }
        return  new ResponseEntity<>(questionFprmUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculatrResult(Long id, List<Response> responses) {
        Quiz quiz= quizDao.findById(id).get();
        List<Question> questions= quiz.getQuestion();

        int right=0;
        int i=0;
        for (Response response: responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}

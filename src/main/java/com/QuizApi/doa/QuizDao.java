package com.QuizApi.doa;

import com.QuizApi.model.Question;
import com.QuizApi.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Long> {
}

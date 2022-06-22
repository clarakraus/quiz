package com.example.QuizGame;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionRepo extends MongoRepository<Question, String> {

    List<Question> findAllByApprovedIsTrue();
}




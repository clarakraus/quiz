package com.example.QuizGame;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class QuizService {

   private final QuestionRepo questionRepo;
    public void saveNewQuestion(Question question) {
        questionRepo.save(question);

    }
    public List<Question> getQuestions(){
        return questionRepo.findAllByApprovedIsTrue();
    }

    public Optional<Question> getQuestionById(String id) {
        return questionRepo.findById(id);
    }
}

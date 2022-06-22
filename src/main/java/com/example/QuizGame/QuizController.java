package com.example.QuizGame;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping()
    public void postQuestionToDB(@RequestBody Question question){
        quizService.saveNewQuestion(question);
    }

    @GetMapping()
    public List<Question> getAllTheQuestions(){
       return quizService.getQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getSingleQuestion(@PathVariable String id){
        return ResponseEntity.of(quizService.getQuestionById(id));
    }
}

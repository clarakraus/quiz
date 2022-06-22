package com.example.QuizGame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "questions")
public class Question {

   @Id
   private String id;

   private String frage;

   private String antwort;

   private boolean approved;

   public Question(String frage, String antwort) {
      this.frage = frage;
      this.antwort = antwort;
   }
}

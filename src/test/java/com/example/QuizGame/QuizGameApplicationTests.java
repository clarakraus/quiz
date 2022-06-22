package com.example.QuizGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuizGameApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	void integrationTest() {
		ResponseEntity<Question[]>response = restTemplate.getForEntity("/quiz", Question[].class);

		Assertions.assertThat(response.getBody()).isEmpty();

		Question newQuestion1 = new Question("testfrage1", "antwort1");
		Question newQuestion2 = new Question(null, "testfrage2", "antwort2", true);
		ResponseEntity<Question> response2 = restTemplate.postForEntity("/quiz",newQuestion1, Question.class);
		ResponseEntity<Question> response3 = restTemplate.postForEntity("/quiz",newQuestion2, Question.class);

		ResponseEntity<Question[]>response4 = restTemplate.getForEntity("/quiz", Question[].class);

		Assertions.assertThat(response4.getBody()).hasSize(1);

	}

}

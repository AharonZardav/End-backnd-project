package com.example.End_project.question;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient (name = "${questionFeignClient.name}", url = "${questionFeignClient.url}")
@FeignClient (name = "question-service", url = "http://localhost:8080/questions")

public interface QuestionFeignClient {

    @GetMapping("/id/{id}")
    Question getQuestion(@PathVariable("id") int id);

    @GetMapping("/all")
    List<Question> getAllQuestions();
}
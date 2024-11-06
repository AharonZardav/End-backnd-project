package com.example.End_project.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        Question questionToCreate = questionService.createQuestion(question);
        if (questionToCreate == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(questionToCreate, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        Question questionToUpdate =  questionService.updateQuestion(question);
        if (questionToUpdate == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionToUpdate, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable int id){
        Question questionToGet = questionService.getQuestion(id);
        if (questionToGet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionToGet, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Question> getQuestion(@PathVariable String title){
        Question questionToGet = questionService.getQuestion(title);
        if (questionToGet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionToGet, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> allQuestions = questionService.getAllQuestions();
        if (allQuestions == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        String questionToDelete = questionService.deleteQuestion(id);
        if (!questionToDelete.contains("deleted successfully")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionToDelete, HttpStatus.OK);
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String title){
        String questionToDelete = questionService.deleteQuestion(title);
        if (!questionToDelete.contains("deleted successfully")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionToDelete, HttpStatus.OK);
    }
}

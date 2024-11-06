package com.example.End_project.poll;

import com.example.End_project.poll.Model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/poll")
public class PollController {

    @Autowired
    PollService pollService;

    //save answer
    @PostMapping
    public ResponseEntity<Poll> sendAnswer(@RequestBody Poll poll){
        Poll pollToSend = pollService.sendAnswer(poll);
        if (pollToSend == null){
            //BAD_REQUEST/NOT_FOUND?
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pollToSend ,HttpStatus.CREATED);
    }

    //return how much users chose on each answer on this question
    @GetMapping("/answersCount/questionId/{questionId}")
    public ResponseEntity<String> getAnswersByUsers(@PathVariable int questionId){
        String listOfAnswersCountByQuestionToGet = String.valueOf(pollService.getAnswersCountByQuestion(questionId));
        if (listOfAnswersCountByQuestionToGet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listOfAnswersCountByQuestionToGet, HttpStatus.OK);
    }

    //return how much users answer on this question
    @GetMapping("/answersSum/questionId/{questionId}")
    public ResponseEntity<Integer> getCountAnswersOnQuestion(@PathVariable int questionId){
        Integer countOfAnswersOnQuestionToGet = pollService.getSumOfAnswersOnQuestion(questionId);
        if (countOfAnswersOnQuestionToGet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(countOfAnswersOnQuestionToGet, HttpStatus.OK);
    }

    //return all questions that the user has answered
    @GetMapping("/userAnswers/userId/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getUserAnswers(@PathVariable int userId){
        List<Map<String, Object>> questionsAndAnswers = pollService.getUserAnswers(userId);
        if (questionsAndAnswers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionsAndAnswers, HttpStatus.OK);
    }

    //return how much questions user answer
    @GetMapping("/answersSum/userId/{userId}")
    public ResponseEntity<Integer> getSumOfAnswersByUser(@PathVariable int userId){
        Integer sumOfAnswersByUser = pollService.getSumOfAnswersByUser(userId);
        if (sumOfAnswersByUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sumOfAnswersByUser, HttpStatus.OK);
    }

    //return all the questions, and for each question, how many users choose on each answer
    @GetMapping("/all")
    public ResponseEntity<String> getAllQuestionsAndAnswersByUsers(){
        String allQuestionsWithAnswersCount = pollService.getAllQuestionsWithAnswersCount().toString();
        if (allQuestionsWithAnswersCount == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allQuestionsWithAnswersCount, HttpStatus.OK);
    }
}

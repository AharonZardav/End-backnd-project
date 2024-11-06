package com.example.End_project.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestion(Question question){
        if (question.getTitle() == null || question.getFirstAnswer() == null || question.getSecondAnswer() == null || question.getThirdAnswer() == null || question.getFourthAnswer() == null){
            System.out.println("QuestionService say: It's impossible to create a new question without all the question details: (title + 4 answers)");
        }
        if (questionRepository.getByTitle(question.getTitle()) != null){
            System.out.println("QuestionService say: Question with this title already exist!");
            return null;
        }
        return questionRepository.create(question);
    }

    public Question updateQuestion(Question question){
        Question existingQuestion = questionRepository.getByTitle(question.getTitle());

        if (existingQuestion == null) {
            System.out.println("QuestionService say: Question with this title doesn't exist!");
            return null;
        }
        if (question.getFirstAnswer() == null){
            question.setFirstAnswer(existingQuestion.getFirstAnswer());
        }
        if (question.getSecondAnswer() == null){
            question.setSecondAnswer(existingQuestion.getSecondAnswer());
        }
        if (question.getThirdAnswer() == null){
            question.setThirdAnswer(existingQuestion.getThirdAnswer());
        }
        if (question.getFourthAnswer() == null){
            question.setFourthAnswer(existingQuestion.getFourthAnswer());
        }
        return questionRepository.update(question);
    }

    public Question getQuestion(int id){
        if (questionRepository.getById(id) == null){
            System.out.println("QuestionService say: Question with this id doesn't exist!");
            return null;
        }
        return questionRepository.getById(id);
    }

    public Question getQuestion(String title){
        if (questionRepository.getByTitle(title) == null){
            System.out.println("Question with this title doesn't exist!");
            return null;
        }
        return questionRepository.getByTitle(title);
    }

    public List<Question> getAllQuestions(){
        if (questionRepository.getAllQuestions() == null){
            System.out.println("There are no questions yet");
            return null;
        }
        return questionRepository.getAllQuestions();
    }

    public String deleteQuestion(int id){
        if (questionRepository.getById(id) == null){
            return "QuestionService say: Question with this id doesn't exist!";
        }
        return questionRepository.deleteById(id);
    }

    public String deleteQuestion(String title){
        if (questionRepository.getByTitle(title) == null){
            return "QuestionService say: Question with this title doesn't exist!";
        }
        return questionRepository.deleteByTitle(title);
    }
}

package com.example.End_project.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepository {

    private static final String QUESTION_TABLE = "questions";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Question create(Question question){
        try {
            String sql = "INSERT INTO "+QUESTION_TABLE+" (title, first_answer, second_answer, third_answer, fourth_answer) VALUES(?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, question.getTitle(), question.getFirstAnswer(), question.getSecondAnswer(),question.getThirdAnswer(), question.getFourthAnswer());
            return getByTitle(question.getTitle());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Question update(Question question){
        try {
            String sql = "UPDATE " + QUESTION_TABLE + " SET title = ?, first_answer = ?, second_answer = ?, third_answer = ?, fourth_answer = ? WHERE id = ?";
            jdbcTemplate.update(sql, question.getTitle(), question.getFirstAnswer(), question.getSecondAnswer(), question.getThirdAnswer(),  question.getFourthAnswer(), getIdByTitleHelper(question.getTitle()));
            return question;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Question getById(Integer id){
        try {
            String sql = "SELECT * FROM "+QUESTION_TABLE+" WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new QuestionMapper(), id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Question getByTitle(String title){
        try {
            String sql = "SELECT * FROM "+QUESTION_TABLE+" WHERE title = ?";
            return jdbcTemplate.queryForObject(sql, new QuestionMapper(), title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Question> getAllQuestions(){
        try {
            String sql = "SELECT * FROM "+QUESTION_TABLE;
            return jdbcTemplate.query(sql, new QuestionMapper());
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteById(int id) {
        try {
            String sql = "DELETE FROM " + QUESTION_TABLE + " WHERE id = ?";
            jdbcTemplate.update(sql, id);
            return "The question with id " + id + " deleted successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String deleteByTitle(String title) {
        try {
            String sql = "DELETE FROM " + QUESTION_TABLE + " WHERE title = ?";
            jdbcTemplate.update(sql, title);
            return "The question with title " + title + " deleted successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public int getIdByTitleHelper(String title){
        try{
            String sql = "SELECT id FROM " + QUESTION_TABLE + " WHERE title = ?";
            Integer id = jdbcTemplate.queryForObject(sql, Integer.class, title);
            if (id == null) {
                System.out.println("No question found with the provided title.");
                return -1;
            }
            return id;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}

package com.example.End_project.question;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("id"));
        question.setTitle(rs.getString("title"));
        question.setFirstAnswer(rs.getString("first_answer"));
        question.setSecondAnswer(rs.getString("second_answer"));
        question.setThirdAnswer(rs.getString("third_answer"));
        question.setFourthAnswer(rs.getString("fourth_answer"));
        return question;
    }
}

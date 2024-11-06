package com.example.End_project.poll.Repository.mapper;

import com.example.End_project.poll.Model.Poll;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollMapper implements RowMapper<Poll>{

    @Override
    public Poll mapRow(ResultSet rs, int rowNum) throws SQLException {
        Poll poll = new Poll();
        poll.setUserId(rs.getInt("user_id"));
        poll.setQuestionId(rs.getInt("question_id"));
        poll.setAnswer(rs.getString("answer"));
        return poll;
    }
}

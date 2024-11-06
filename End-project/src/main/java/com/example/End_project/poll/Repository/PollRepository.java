package com.example.End_project.poll.Repository;

import com.example.End_project.poll.Model.Poll;
import com.example.End_project.poll.Repository.mapper.PollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PollRepository {

    private static final String POLL_TABLE = "users_answers";

    @Autowired
    JdbcTemplate jdbcTemplate;

    //INSERT INTO users_answers (user_id, question_id, answer) VALUES (1, 1, 'a')
    public Poll sendNewAnswer(Poll poll){
        try {
            String sql = "INSERT INTO "+POLL_TABLE+" (user_id, question_id, answer) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, poll.getUserId(), poll.getQuestionId(), poll.getAnswer());
            return getByUserIdAndQuestionId(poll);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //test
//    public List<Map<String, Object>> getAnswersCountsByQuestionId(int questionId) {
//        try {
//            String sql = "SELECT answer, COUNT(*) AS count FROM "+POLL_TABLE+" WHERE question_id = ? GROUP BY answer";
//            return jdbcTemplate.queryForList(sql, questionId);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    public List<Map<String, Object>> getAnswersCountsByQuestionId(int questionId) {
        try {
            String sql = "SELECT answer, COUNT(*) AS count FROM "+POLL_TABLE+" WHERE question_id = ? GROUP BY answer";
            return jdbcTemplate.queryForList(sql, questionId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer getCountOfUsersAnswersOnThisQuestion(int questionId){
        try {
            String sql = "SELECT COUNT(user_id) AS user_count FROM "+POLL_TABLE+" WHERE question_id = ?";
            return jdbcTemplate.queryForObject(sql, Integer.class, questionId);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //SELECT users_answers.question_id, users_answers.answer FROM USERS_ANSWERS WHERE users_answers.user_id = 1;
    public List<Map<String, Object>> getUserAnswers(int userId){
        try {
            String sql = "SELECT "+POLL_TABLE+".question_id, "+POLL_TABLE+".answer FROM "+POLL_TABLE+" WHERE "+POLL_TABLE+".user_id = ?";
            return jdbcTemplate.queryForList(sql, userId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer getSumOfAnswersByUser(int userId){
        try {
            String sql = "SELECT COUNT(question_id) AS question_count FROM "+POLL_TABLE+" WHERE user_id = ?";
            return jdbcTemplate.queryForObject(sql, Integer.class, userId);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //SELECT * FROM users_answers WHERE user_id = 1 AND question_id = 1;
    public Poll getByUserIdAndQuestionId(Poll poll){
        try {
            String sql = "SELECT * FROM "+POLL_TABLE+ " WHERE user_id = ? AND question_id = ?";
            return jdbcTemplate.queryForObject(sql, new PollMapper(), poll.getUserId(), poll.getQuestionId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //delete?
//    public List<Integer> getAllQuestionsWithAnswersCount(){
//        try {
//            String sql  = "SELECT * FROM "+POLL_TABLE+" WHERE "
//        }
//    }

//    public Poll updateAnswer(Poll poll){
//        try {
//            String sql = "UPDATE "+POLL_TABLE+" SET answer = ? WHERE user_id = ? AND question_id = ?";
//            jdbcTemplate.update(sql, poll.getUserId(), poll.getQuestionId());
//            return getByUserIdAndQuestionId(poll);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

//    public void deleteAnswer()
}

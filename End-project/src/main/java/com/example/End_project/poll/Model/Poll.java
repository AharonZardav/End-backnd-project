package com.example.End_project.poll.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Poll {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("question_id")
    private int questionId;
    private String answer;

    public Poll() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "userId=" + userId +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                '}';
    }
}

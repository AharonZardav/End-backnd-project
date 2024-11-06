package com.example.End_project.poll.Model;

public class AnswerCount {
    private String answer;
    private int count;

    public AnswerCount(String answer, int count) {
        this.answer = answer;
        this.count = count;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AnswerCount{" +
                "answer='" + answer + '\'' +
                ", count=" + count +
                '}';
    }
}

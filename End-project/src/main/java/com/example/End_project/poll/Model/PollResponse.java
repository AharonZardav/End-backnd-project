package com.example.End_project.poll.Model;

public class PollResponse {
    private AnswerCount[] answers;
    int questionId;

    public PollResponse(int questionId) {
        this.questionId = questionId;
        answers = new AnswerCount[4];
        answers[0] = new AnswerCount("a", 0);
        answers[1] = new AnswerCount("b", 0);
        answers[2] = new AnswerCount("c", 0);
        answers[3] = new AnswerCount("d", 0);
    }

    public AnswerCount[] getAnswers() {
        return answers;
    }

    public void setAnswerA(String answer) {
        this.answers[0].setAnswer(answer);
    }

    public void setCountA(int count){
        this.answers[0].setCount(count);
    }

    public String getAnswerA(){
        return answers[0].getAnswer();
    }

    public int getCountA(){
        return answers[0].getCount();
    }

    public void setAnswerB(String answer) {
        this.answers[1].setAnswer(answer);
    }

    public void setCountB(int count){
        this.answers[1].setCount(count);
    }

    public String getAnswerB(){
        return answers[1].getAnswer();
    }

    public int getCountB(){
        return answers[1].getCount();
    }

    public void setAnswerC(String answer) {
        this.answers[2].setAnswer(answer);
    }

    public void setCountC(int count){
        this.answers[2].setCount(count);
    }

    public String getAnswerC(){
        return answers[2].getAnswer();
    }

    public int getCountC(){
        return answers[2].getCount();
    }

    public void setAnswerD(String answer) {
        this.answers[3].setAnswer(answer);
    }

    public void setCountD(int count){
        this.answers[3].setCount(count);
    }

    public String getAnswerD(){
        return answers[3].getAnswer();
    }

    public int getCountD(){
        return answers[3].getCount();
    }

    @Override
    public String toString() {
        return  "{" +
                    "\"questionId\":"+questionId+",\n"+
                    "\"answers\": [" +
                        "{" +
                            "\"answer\": \""+answers[0].getAnswer()+"\""+
                            ", \"count\":"+answers[0].getCount()+
                        "}, " +
                        "{" +
                            "\"answer\": \""+answers[1].getAnswer()+"\""+
                            ", \"count\":"+answers[1].getCount()+
                        "}, "+
                        "{" +
                            "\"answer\": \""+answers[2].getAnswer()+"\""+
                            ", \"count\":"+answers[2].getCount()+
                        "}, "+
                        "{" +
                            "\"answer\": \""+answers[3].getAnswer()+"\""+
                            ", \"count\":"+answers[3].getCount()+
                        "} "+
                    "] "+
                "}";
    }
}
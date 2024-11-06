package com.example.End_project.question;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private int id;
    private String title;
    @JsonProperty("first_answer")
    private String firstAnswer;
    @JsonProperty("second_answer")
    private String secondAnswer;
    @JsonProperty("third_answer")
    private String thirdAnswer;
    @JsonProperty("fourth_answer")
    private String fourthAnswer;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstAnswer='" + firstAnswer + '\'' +
                ", secondAnswer='" + secondAnswer + '\'' +
                ", thirdAnswer='" + thirdAnswer + '\'' +
                ", fourthAnswer='" + fourthAnswer + '\'' +
                '}';
    }
}

//public class Question {
//    private int id;
//    private String title;
//    private String a;
//    private String b;
//    private String c;
//    private String d;
//
//    public Question() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getFirstAnswer() {
//        return a;
//    }
//
//    public void setFirstAnswer(String firstAnswer) {
//        this.a = a;
//    }
//
//    public String getSecondAnswer() {
//        return b;
//    }
//
//    public void setSecondAnswer(String secondAnswer) {
//        this.b = b;
//    }
//
//    public String getThirdAnswer() {
//        return c;
//    }
//
//    public void setThirdAnswer(String thirdAnswer) {
//        this.c = c;
//    }
//
//    public String getFourthAnswer() {
//        return d;
//    }
//
//    public void setFourthAnswer(String fourthAnswer) {
//        this.d = d;
//    }
//
//    @Override
//    public String toString() {
//        return "Question{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", a='" + a + '\'' +
//                ", b='" + b + '\'' +
//                ", c='" + c + '\'' +
//                ", d='" + d + '\'' +
//                '}';
//    }
//}

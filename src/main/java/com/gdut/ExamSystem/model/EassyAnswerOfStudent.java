package com.gdut.ExamSystem.model;

public class EassyAnswerOfStudent extends EassyAnswerOfStudentKey {
    private Integer orders;

    private Integer score;

    private String answer;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}
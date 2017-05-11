package com.gdut.ExamSystem.model;

public class BlankFillingAnswerOfStudentJunction extends BlankFillingAnswerOfStudentJunctionKey {
    private Integer orders;

    private Integer score;

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
}
package com.gdut.ExamSystem.model;

public class BlankFillingAnswerOfStudent {
    private Integer blankFillingAnswerId;

    private Integer orders;

    private String answer;

    public Integer getBlankFillingAnswerId() {
        return blankFillingAnswerId;
    }

    public void setBlankFillingAnswerId(Integer blankFillingAnswerId) {
        this.blankFillingAnswerId = blankFillingAnswerId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}
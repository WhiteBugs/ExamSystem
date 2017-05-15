package com.gdut.ExamSystem.model;

public class BlankFillingAnswer {
    private Integer blankFillingQuestionId;

    private Integer orders;

    private String answer;

    public Integer getBlankFillingQuestionId() {
        return blankFillingQuestionId;
    }

    public void setBlankFillingQuestionId(Integer blankFillingQuestionId) {
        this.blankFillingQuestionId = blankFillingQuestionId;
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
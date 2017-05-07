package com.gdut.ExamSystem.model;

public class BlankFillingAnswer {
    private Integer orders;

    private Integer blankFillingQuestionId;

    private String answer;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getBlankFillingQuestionId() {
        return blankFillingQuestionId;
    }

    public void setBlankFillingQuestionId(Integer blankFillingQuestionId) {
        this.blankFillingQuestionId = blankFillingQuestionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}
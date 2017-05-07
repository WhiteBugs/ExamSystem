package com.gdut.ExamSystem.model;

public class BlankFillingJunction {
    private Integer orders;

    private Integer examId;

    private Integer blankFillingQuestionId;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getBlankFillingQuestionId() {
        return blankFillingQuestionId;
    }

    public void setBlankFillingQuestionId(Integer blankFillingQuestionId) {
        this.blankFillingQuestionId = blankFillingQuestionId;
    }
}
package com.gdut.ExamSystem.model;

public class TrueFalseQuestionJunction extends TrueFalseQuestionJunctionKey {
    private String order;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order == null ? null : order.trim();
    }
}
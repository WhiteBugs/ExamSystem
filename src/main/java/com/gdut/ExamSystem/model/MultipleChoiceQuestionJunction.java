package com.gdut.ExamSystem.model;

public class MultipleChoiceQuestionJunction extends MultipleChoiceQuestionJunctionKey {
    private String order;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order == null ? null : order.trim();
    }
}
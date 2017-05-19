package com.gdut.ExamSystem.model;

public class BlankFillingAnswer extends BlankFillingAnswerKey {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}
package com.gdut.ExamSystem.model;

public class BlankFillingAnswerOfStudent extends BlankFillingAnswerOfStudentKey {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}
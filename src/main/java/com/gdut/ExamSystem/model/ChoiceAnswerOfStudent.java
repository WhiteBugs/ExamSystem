package com.gdut.ExamSystem.model;

public class ChoiceAnswerOfStudent extends ChoiceAnswerOfStudentKey {
    private String answer;

    private Integer score;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
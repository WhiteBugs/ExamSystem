package com.gdut.ExamSystem.model;

public class TeacherWithBLOBs extends Teacher {
    private String safeQuestion;

    private String safeAnswer;

    public String getSafeQuestion() {
        return safeQuestion;
    }

    public void setSafeQuestion(String safeQuestion) {
        this.safeQuestion = safeQuestion == null ? null : safeQuestion.trim();
    }

    public String getSafeAnswer() {
        return safeAnswer;
    }

    public void setSafeAnswer(String safeAnswer) {
        this.safeAnswer = safeAnswer == null ? null : safeAnswer.trim();
    }
}
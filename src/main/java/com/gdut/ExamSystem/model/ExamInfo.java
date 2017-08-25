package com.gdut.ExamSystem.model;

public class ExamInfo extends ExamInfoKey {
    private Integer score;

    private String examName;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }
}
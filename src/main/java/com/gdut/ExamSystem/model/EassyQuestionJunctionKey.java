package com.gdut.ExamSystem.model;

public class EassyQuestionJunctionKey {
    private Integer eassyQuestionId;

    private String examId;

    public Integer getEassyQuestionId() {
        return eassyQuestionId;
    }

    public void setEassyQuestionId(Integer eassyQuestionId) {
        this.eassyQuestionId = eassyQuestionId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }
}
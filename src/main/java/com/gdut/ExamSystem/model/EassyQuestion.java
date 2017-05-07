package com.gdut.ExamSystem.model;

public class EassyQuestion {
    private Integer eassyQuestionId;

    private String tittle;

    private String answer;

    public Integer getEassyQuestionId() {
        return eassyQuestionId;
    }

    public void setEassyQuestionId(Integer eassyQuestionId) {
        this.eassyQuestionId = eassyQuestionId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}
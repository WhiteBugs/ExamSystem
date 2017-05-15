package com.gdut.ExamSystem.model;

public class BlankFillingQuestion {
    private Integer blankFillingQuestionId;

    private String tittle;

    public Integer getBlankFillingQuestionId() {
        return blankFillingQuestionId;
    }

    public void setBlankFillingQuestionId(Integer blankFillingQuestionId) {
        this.blankFillingQuestionId = blankFillingQuestionId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }
}
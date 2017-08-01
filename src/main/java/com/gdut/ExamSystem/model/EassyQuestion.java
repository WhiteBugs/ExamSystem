package com.gdut.ExamSystem.model;

public class EassyQuestion {
    private Integer eassyQuestionId;

    private String title;

    private String answer;

    public Integer getEassyQuestionId() {
        return eassyQuestionId;
    }

    public void setEassyQuestionId(Integer eassyQuestionId) {
        this.eassyQuestionId = eassyQuestionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}
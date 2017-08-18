package com.gdut.ExamSystem.model;

public class TrueFalseQuestion {
    private Integer trueFalseQuestionId;

    private String title;

    private String answer;

    public Integer getTrueFalseQuestionId() {
        return trueFalseQuestionId;
    }

    public void setTrueFalseQuestionId(Integer trueFalseQuestionId) {
        this.trueFalseQuestionId = trueFalseQuestionId;
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
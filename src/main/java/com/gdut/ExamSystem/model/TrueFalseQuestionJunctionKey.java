package com.gdut.ExamSystem.model;

public class TrueFalseQuestionJunctionKey {
    private Integer trueFalseQuestionTrueFalseQuestionId;

    private String testPaperExamId;

    public Integer getTrueFalseQuestionTrueFalseQuestionId() {
        return trueFalseQuestionTrueFalseQuestionId;
    }

    public void setTrueFalseQuestionTrueFalseQuestionId(Integer trueFalseQuestionTrueFalseQuestionId) {
        this.trueFalseQuestionTrueFalseQuestionId = trueFalseQuestionTrueFalseQuestionId;
    }

    public String getTestPaperExamId() {
        return testPaperExamId;
    }

    public void setTestPaperExamId(String testPaperExamId) {
        this.testPaperExamId = testPaperExamId == null ? null : testPaperExamId.trim();
    }
}
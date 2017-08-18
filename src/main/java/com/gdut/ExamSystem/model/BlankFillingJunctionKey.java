package com.gdut.ExamSystem.model;

public class BlankFillingJunctionKey {
    private Integer blankFillingQuestionId;

    private String testPaperExamId;

    public Integer getBlankFillingQuestionId() {
        return blankFillingQuestionId;
    }

    public void setBlankFillingQuestionId(Integer blankFillingQuestionId) {
        this.blankFillingQuestionId = blankFillingQuestionId;
    }

    public String getTestPaperExamId() {
        return testPaperExamId;
    }

    public void setTestPaperExamId(String testPaperExamId) {
        this.testPaperExamId = testPaperExamId == null ? null : testPaperExamId.trim();
    }
}
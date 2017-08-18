package com.gdut.ExamSystem.model;

public class MultipleChoiceQuestionJunctionKey {
    private Integer multipleChoiceQuestionMultipleChoiceQuestionId;

    private String testPaperExamId;

    public Integer getMultipleChoiceQuestionMultipleChoiceQuestionId() {
        return multipleChoiceQuestionMultipleChoiceQuestionId;
    }

    public void setMultipleChoiceQuestionMultipleChoiceQuestionId(Integer multipleChoiceQuestionMultipleChoiceQuestionId) {
        this.multipleChoiceQuestionMultipleChoiceQuestionId = multipleChoiceQuestionMultipleChoiceQuestionId;
    }

    public String getTestPaperExamId() {
        return testPaperExamId;
    }

    public void setTestPaperExamId(String testPaperExamId) {
        this.testPaperExamId = testPaperExamId == null ? null : testPaperExamId.trim();
    }
}
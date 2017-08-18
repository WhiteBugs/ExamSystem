package com.gdut.ExamSystem.model;

public class BlankFillingAnswerOfStudentJunctionKey {
    private Integer blankFillingAnswerIdOfStudent;

    private Long studentId;

    private Integer orders;

    private String testPaperExamId;

    public Integer getBlankFillingAnswerIdOfStudent() {
        return blankFillingAnswerIdOfStudent;
    }

    public void setBlankFillingAnswerIdOfStudent(Integer blankFillingAnswerIdOfStudent) {
        this.blankFillingAnswerIdOfStudent = blankFillingAnswerIdOfStudent;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getTestPaperExamId() {
        return testPaperExamId;
    }

    public void setTestPaperExamId(String testPaperExamId) {
        this.testPaperExamId = testPaperExamId == null ? null : testPaperExamId.trim();
    }
}
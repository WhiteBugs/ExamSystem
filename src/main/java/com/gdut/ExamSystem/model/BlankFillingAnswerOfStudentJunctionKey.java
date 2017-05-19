package com.gdut.ExamSystem.model;

public class BlankFillingAnswerOfStudentJunctionKey {
    private Integer blankFillingAnswerIdOfStudent;

    private Integer examId;

    private Long studentId;

    private Integer orders;

    public Integer getBlankFillingAnswerIdOfStudent() {
        return blankFillingAnswerIdOfStudent;
    }

    public void setBlankFillingAnswerIdOfStudent(Integer blankFillingAnswerIdOfStudent) {
        this.blankFillingAnswerIdOfStudent = blankFillingAnswerIdOfStudent;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
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
}
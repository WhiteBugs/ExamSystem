package com.gdut.ExamSystem.model;

public class BlankFillingAnswerOfStudentJunction {
    private Integer orders;

    private Integer score;

    private Long studentId;

    private Integer examId;

    private Integer blankFillingAnswerOfStudentBlankFillingAnswerId;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getBlankFillingAnswerOfStudentBlankFillingAnswerId() {
        return blankFillingAnswerOfStudentBlankFillingAnswerId;
    }

    public void setBlankFillingAnswerOfStudentBlankFillingAnswerId(Integer blankFillingAnswerOfStudentBlankFillingAnswerId) {
        this.blankFillingAnswerOfStudentBlankFillingAnswerId = blankFillingAnswerOfStudentBlankFillingAnswerId;
    }
}
package com.gdut.ExamSystem.model;

public class BlankFillingAnswerOfStudentJunctionKey {
    private Integer blankFillingAnswerOfStudentBlankFillingAnswerId;

    private Integer examId;

    private Long studentId;

    public Integer getBlankFillingAnswerOfStudentBlankFillingAnswerId() {
        return blankFillingAnswerOfStudentBlankFillingAnswerId;
    }

    public void setBlankFillingAnswerOfStudentBlankFillingAnswerId(Integer blankFillingAnswerOfStudentBlankFillingAnswerId) {
        this.blankFillingAnswerOfStudentBlankFillingAnswerId = blankFillingAnswerOfStudentBlankFillingAnswerId;
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
}
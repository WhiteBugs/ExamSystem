package com.gdut.ExamSystem.model;

public class CountExamJunctionKey {
    private String teacherCount;

    private String testPaperExamId;

    public String getTeacherCount() {
        return teacherCount;
    }

    public void setTeacherCount(String teacherCount) {
        this.teacherCount = teacherCount == null ? null : teacherCount.trim();
    }

    public String getTestPaperExamId() {
        return testPaperExamId;
    }

    public void setTestPaperExamId(String testPaperExamId) {
        this.testPaperExamId = testPaperExamId == null ? null : testPaperExamId.trim();
    }
}
package com.gdut.ExamSystem.model;

import java.math.BigDecimal;

public class Student {
	//学生：学号 考生号 身份证号 姓名 性别 年级 专业 密码  成绩 
    private Short studentid;

    private Short examineenumber;

    private Short id;

    private String name;

    private String sex;

    private BigDecimal grade;

    private String major;

    private BigDecimal classes;

    private String password;

    private BigDecimal score;

    public Short getStudentid() {
        return studentid;
    }

    public void setStudentid(Short studentid) {
        this.studentid = studentid;
    }

    public Short getExamineenumber() {
        return examineenumber;
    }

    public void setExamineenumber(Short examineenumber) {
        this.examineenumber = examineenumber;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public BigDecimal getClasses() {
        return classes;
    }

    public void setClasses(BigDecimal classes) {
        this.classes = classes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
package com.gdut.ExamSystem.model;


public class Student {
	//学生：学号 考生号 身份证号 姓名 性别 年级 专业 密码  成绩 
    private long studentid;

    private long examineenumber;

    private long id;

    private String name;

    private String sex;

    private int grade;

    private String major;

    private int classes;

    private String password;

    private int score;

    public long getStudentid() {
        return studentid;
    }

    public void setStudentid(long studentid) {
        this.studentid = studentid;
    }

    public long getExamineenumber() {
        return examineenumber;
    }

    public void setExamineenumber(long examineenumber) {
        this.examineenumber = examineenumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
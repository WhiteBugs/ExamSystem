package com.gdut.ExamSystem.student;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;

import com.gdut.ExamSystem.Sex;


public class Student {
	//学生：学号 考生号 身份证号 账户名 姓名 性别 年级 专业 密码 考试用时 成绩 试卷 答案 
	private long studentId;//学号
	private long ExamineeNumber;//考生号
	private long Id;//身份证号
	private String userName;//账户名
	private String name;//姓名
	private Sex sex;//性别
	private int grade;//年级
	private String major;//专业
	private long password;//密码
	private int minutePassed;//考试用时
	private int score;//成绩
	private int testId;//试卷ID
	
	public void setStudentId(long studentId){
		this.studentId=studentId;
	}
	
	public void setExamineeNumber(long ExamineeNumber){
		this.ExamineeNumber=ExamineeNumber;
	}
	
	public void setId(long Id){
		this.Id=Id;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setSex(Sex sex){
		this.sex=sex;
	}
	
	public void setGrade(int grade){
		this.grade=grade;
	}
	
	public void setMajor(String major){
		this.major=major;
	}
	
	public void setPassword(long password){
		this.password=password;
	}
	
	public void setMinutePassed(int minutePassed){
		this.minutePassed=minutePassed;
	}
	
	public void setScore(int score){
		this.score=score;
	}
	
	public void setTestId(int testId){
		this.testId=testId;
	}
	
	
	//get方法
	public long getStudentId(){
		return this.studentId;
	}
	
	public long getExamineeNumber(){
		return this.ExamineeNumber;
	}
	
	public long getId(){
		return this.Id;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Sex getSex(){
		return this.sex;
	}
	
	public int getGrade(){
		return this.grade;
	}
	
	public String getMajor(){
		return this.major;
	}
	
	public long getPassword(){
		return this.password;
	}
	
	public int getMinutePassed(){
		return this.minutePassed;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public int getTestId(){
		return this.testId;
	}
	
	

}

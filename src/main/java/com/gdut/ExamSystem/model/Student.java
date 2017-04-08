package com.gdut.ExamSystem.model;

import com.gdut.ExamSystem.enums.Sex;

public class Student {
	//学生：学号 考生号 身份证号 姓名 性别 年级 专业 密码  成绩 
			private long studentId;//学号
			private long ExamineeNumber;//考生号
			private long Id;//身份证号
			private String name;//姓名
			private Sex sex;//性别
			private int grade;//年级
			private String major;//专业
			private int classes;
			private long password;//密码
			private int score;//成绩
			
			public void setStudentId(long studentId){
				this.studentId=studentId;
			}
			
			public void setExamineeNumber(long ExamineeNumber){
				this.ExamineeNumber=ExamineeNumber;
			}
			
			public void setId(long Id){
				this.Id=Id;
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
			
			public void setClasses(int classes){
				this.classes=classes;
			}
			
			public void setPassword(long password){
				this.password=password;
			}
			
			public void setScore(int score){
				this.score=score;
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
			
			
			public String getName(){
				return this.name;
			}
			
			public Sex getSex(){
				return this.sex;
			}
			
			public int getGrade(){
				return this.grade;
			}
			
			public int getClasses(){
				return this.classes;
			}
			
			public String getMajor(){
				return this.major;
			}
			
			public long getPassword(){
				return this.password;
			}
			
			
			public int getScore(){
				return this.score;
			}
}
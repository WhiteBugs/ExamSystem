package com.gdut.ExamSystem.model;

public class ExamInfo{
	
	private String examName;
	
	private int score;
	
	
	public void setExamName(String examName){
		this.examName = examName;
	}
	public String getExamName(){
		return examName;
	}
	public void setScore(int score){
		this.score=score;
	}
	public int getScore(){
		return score;
	}
}

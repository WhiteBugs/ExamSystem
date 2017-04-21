package com.gdut.ExamSystem.model;

public class ChoiceQuestion extends Question {

	private String question;
	private String answer;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int number;
	
	public String getQuestion(){
		return this.question;
	}
	
	public void setQuestion(String question){
		this.question=question;
	}
	
	public String getAnswer(){
		return this.answer;
	}
	
	public void setAnswer(String answer){
		this.answer=answer;
	}
	
	public String getOption1(){
		return this.option1;
	}
	
	public void setOptioin1(String option1){
		this.option1 = option1;
	}
	
	public String getOption2(){
		return this.option2;
	}
	
	public void setOptioin2(String option2){
		this.option2 = option2;
	}
	
	public String getOption3(){
		return this.option3;
	}
	
	public void setOptioin3(String option3){
		this.option3 = option3;
	}
	
	public String getOption4(){
		return this.option4;
	}
	
	public void setOptioin4(String option4){
		this.option4 = option4;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
}

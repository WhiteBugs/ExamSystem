package com.gdut.ExamSystem.model;

public class Question {

	private String title ;
	
	private int questionId;
	
	private String answer;
	
	private String studentAnswer;
	
	private String questionType;
	
	private String choice1;
	
	private String choice2;
	
	private String choice3;
	
	private String choice4;
	
	private int order;
	
	private int score;
	
	private int studentScore;
	
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setQuestionId(int questionId){
		this.questionId = questionId;
	}

	public int getQuestionId(){
		return questionId;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	public String getAnswer(){
		return answer;
	}
	
	public void setStudentAnswer(String studentAnswer){
		this.studentAnswer = studentAnswer;
	}
	
	public String getStudentAnswer(){
		return studentAnswer;
	}
	
	public void setQuestionType(String questionType){
		this.questionType = questionType;
	}
	
	public String getQuestionType(){
		return questionType;
	}
	
	public void setChoice1(String choice1){
		this.choice1 = choice1;
	}
	
	public String getChoice1(){
		return choice1;
	}
	
	public void setChoice2(String choice2){
		this.choice2 = choice2;
	}
	
	public String getChoice2(){
		return choice2;
	}
	
	public void setChoice3(String choice3){
		this.choice3 = choice3;
	}
	
	public String getChoice3(){
		return choice3;
	}
	
	public void setChoice4(String choice4){
		this.choice4 = choice4;
	}
	
	public String getChoice4(){
		return choice4;
	}

	public void setOrder(int order){
		this.order = order;
	}
	
	public int getOrder(){
		return order;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setStudentScore(int studentScore){
		this.studentScore = studentScore;
	}
	
	public int getStudentScore(){
		return studentScore;
	}
}

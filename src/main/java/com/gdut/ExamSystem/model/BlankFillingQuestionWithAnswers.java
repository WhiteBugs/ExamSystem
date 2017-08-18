package com.gdut.ExamSystem.model;


import java.util.List;

public class BlankFillingQuestionWithAnswers extends BlankFillingQuestion {

	private List<BlankFillingAnswer> answers;
	
	public void setAnswers(List<BlankFillingAnswer> answers){
		this.answers = answers;
	}
	
	public List<BlankFillingAnswer> getAnswers(){
		return this.answers;
	}
}

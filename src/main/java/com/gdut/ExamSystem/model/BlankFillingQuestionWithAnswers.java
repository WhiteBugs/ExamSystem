package com.gdut.ExamSystem.model;

import java.util.ArrayList;

public class BlankFillingQuestionWithAnswers extends BlankFillingQuestion {

	private ArrayList<BlankFillingAnswer> answers;
	
	private void setAnswers(ArrayList<BlankFillingAnswer> answers){
		this.answers = answers;
	}
	
	private ArrayList<BlankFillingAnswer> getAnswers(){
		return this.answers;
	}
}

package com.gdut.ExamSystem.model;

import java.util.ArrayList;

public class BlankFillingQuestion  {
	private String question;
	private String answer;
	
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

	private ArrayList<String> answers = new ArrayList<String>();
	@Override
	public String getAnswer(){
		StringBuilder answer = new StringBuilder();
		for(int i=0;i<this.answers.size();i++){
			answer.append(this.answers.get(i) + "   ");
		}
		return answer.toString();
	}
	
	public ArrayList<String> getAnswerList(){
		return answers;
	}
	
	public void setAnswer(String answer){
		this.answers.add(answer);
	}
	
	public void deleteAnswerByString(String answer) {
		for(int i=0;i<=this.answers.size();i++){
			if(this.answers.get(i).equals(answer)){
				this.answers.remove(i);
				break;
			}
			if(this.answers.size()==i){

			}
		}
	}
	
	public void deleteAnswerByIndex(int index){
		answers.remove(index);
	}
}

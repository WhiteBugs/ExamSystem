package com.gdut.ExamSystem.service;

import com.gdut.ExamSystem.model.Adminstrator;

public interface AdminService {
	public Adminstrator findAdminByCount(String count);
	public void setSafeQuestionAndAnswer(String question,String answer);
	public void changeAdminPassword(String password);
	public void changeSafeQuestion(String question);
	public void changeSafeAnswer(String answer);
	
}

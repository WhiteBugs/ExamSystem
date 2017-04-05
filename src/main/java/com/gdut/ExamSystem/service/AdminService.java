package com.gdut.ExamSystem.service;

import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.service.base.BaseService;

public interface AdminService extends BaseService{
	public Adminstrator findAdminByCount(String count);
	public void setSafeQuestionAndAnswer(String question,String answer);
	public void changeAdminPassword(String password);
	public void changeSafeQuestion(String question);
	public void changeSafeAnswer(String answer);
	
}

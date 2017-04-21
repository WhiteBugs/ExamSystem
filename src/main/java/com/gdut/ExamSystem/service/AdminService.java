package com.gdut.ExamSystem.service;

import com.gdut.ExamSystem.model.Adminstrator;

public interface AdminService {
	Adminstrator findAdminByCount(String count);
	void setSafeQuestionAndAnswer(String question,String answer);
	void changeAdminPassword(String password);
	void changeSafeQuestion(String question);
    void changeSafeAnswer(String answer);
}

package com.gdut.ExamSystem.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.ExamSystem.dao.AdminstratorMapper;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.service.AdminService;


@Service  
@Transactional
public class AdminServiceImp implements AdminService {
	
	@Resource(name="AdminMapper")
	private AdminstratorMapper adminMapper;


	@Override
	public Adminstrator findAdminByCount(String count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSafeQuestionAndAnswer(String question, String answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeAdminPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeSafeQuestion(String question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeSafeAnswer(String answer) {
		// TODO Auto-generated method stub
		
	}

	

}

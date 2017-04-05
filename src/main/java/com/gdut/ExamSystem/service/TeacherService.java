package com.gdut.ExamSystem.service;

import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.service.base.BaseService;

public interface TeacherService extends BaseService {
	
	public void addTeacher(Teacher teacher);
	
	public void deleteTeacherByCount(String Count);
	
	public Teacher findTeacherByCount(String count);
	
	public void changeTeacherPassword(String password);
	public void changeTeacherSafeQuesTion(String question);
	public void changeTeacherSafeAnswer(String answer);
}

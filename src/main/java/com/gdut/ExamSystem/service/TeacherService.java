package com.gdut.ExamSystem.service;

import com.gdut.ExamSystem.model.Teacher;

public interface TeacherService {
	
	public void addTeacher(Teacher teacher);
	
	public void deleteTeacherByCount(String Count);
	
	public Teacher findTeacherByCount(String count);
	
	public void changeTeacherPassword(String password);
	public void changeTeacherSafeQuesTion(String question);
	public void changeTeacherSafeAnswer(String answer);
}

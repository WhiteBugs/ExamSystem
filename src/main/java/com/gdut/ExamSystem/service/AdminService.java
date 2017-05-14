package com.gdut.ExamSystem.service;

import java.util.List;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.model.TestPaperKey;


public interface AdminService {
	AdminstratorWithBLOBs findAdminByCount(String count);
	
	boolean isExist(String count);
	
	void setSafeQuestionAndAnswer(String count,String question,String answer);
	
	void changeAdminPassword(String count,String password);
	
	void changeSafeQuestion(String count,String question);
	
    void changeSafeAnswer(String count,String answer);
    
    void addStudent(TestPaperKey testPaperKey,Student student);
    
    void updateStudent(Student student);
    
    void deleteStudent(TestPaperKey testPaperKey,Student student);
    
    void addTeacher(TestPaperKey testPaperKey,Teacher teacher);
    
    void updateTeacher(TeacherWithBLOBs teacher);
    
    void deleteTeacher( Teacher teacher);
    
    void addExam(TestPaper testPaper,Teacher teacher,List<Long> studentIDList);
}

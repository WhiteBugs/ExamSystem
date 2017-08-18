package com.gdut.ExamSystem.service;

import java.util.List;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;



public interface AdminService {
	AdminstratorWithBLOBs findAdminByCount(String count);
	
	boolean isExist(String count);
	
	void setSafeQuestionAndAnswer(String count,String question,String answer);
	
	void changeAdminPassword(String count,String password);
	
	void changeSafeQuestion(String count,String question);
	
    void changeSafeAnswer(String count,String answer);
    
    void addStudent(String examId, Student student);
    
    void updateStudent(Student student);
    
    void deleteStudent(String examId, Student student);
    
    void addTeacher(String examId, List<String> teacher);
    
    void updateTeacher(TeacherWithBLOBs teacher);
    
    void deleteTeacher( Teacher teacher);
    
    void addExam(TestPaper testPaper,Teacher teacher,List<Long> studentIDList);
}

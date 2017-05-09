package com.gdut.ExamSystem.service;

import java.util.List;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.model.TestPaperKey;

public interface AdminService {
	AdminstratorWithBLOBs findAdminByCount(String count);
	void setSafeQuestionAndAnswer(String count,String question,String answer);
	void changeAdminPassword(String count,String password);
	void changeSafeQuestion(String count,String question);
    void changeSafeAnswer(String count,String answer);
    void addStudent(TestPaper testPaper,Student student);
    void updateStudent(TestPaper testPaper,Student student);
    void deleteStudent(TestPaper testPaper,Student student);
    void addTeacher(TestPaper testPaper,Teacher teacher);
    void updateTeacher(TestPaper testPaper,Teacher teacher);
    void deleteTeacher(TestPaper testPaper,Teacher teacher);
    void addExam(TestPaper testPaper,Teacher teacher,List<Student> studentList);
}

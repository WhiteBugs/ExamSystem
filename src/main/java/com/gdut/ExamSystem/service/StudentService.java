package com.gdut.ExamSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.ExamSystem.enums.Major;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;
import com.gdut.ExamSystem.model.TestPaper;

@Service 
@Transactional
public interface StudentService {
	
     public void add(Student student);
     
     public void delete(Student student);
     public void deleteByGrade(int grade);
     public void deleteByStudentID(long studentID);
     public void deleteByExamineeNumber(long examineeNumber);
     public void delettByClass(int classes);
     
     public Student findStudentByStudentID(long studentID);
     public Student findStudentByExamineeNumber(long examineeNumber);
     public ArrayList<Student> findStudentByName(String name);
     public ArrayList<Student> findStudentByClasses(int classes);
     public ArrayList<Student> findStudentByMajor(Major major);
     public ArrayList<Student> findStudentScoreBelow(int score);
     public ArrayList<Student> findStudentScoreHigerThanScore(int score);
     public ArrayList<Student> findStudentScoreBetweenScore(@Param("higherScore")int higherScore,@Param("lowScore")int lowScore);
     public List<Integer> findStudentExam(long studentID);
     
     public boolean isStudentExist(long studentID);
     
     public void changeStudentExamineeNumber(long ExamineeNumber,Student student);
     public void changeStudentName(String name,Student student);
     public void changeStudentSex(String sex,Student student);
     public void changeStudentGrade(int grade,Student student);
     public void changeStudentClasses(int classes,Student student);
     public void changeStudentMajor(String major,Student student);
     public void changeStudentPassword(String password,Student student);
     public void changeStudentScore(int score,Student student);
     
}

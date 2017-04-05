package com.gdut.ExamSystem.service;

import java.util.ArrayList;
import com.gdut.ExamSystem.Major;
import com.gdut.ExamSystem.Sex;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.service.base.BaseService;

public interface StudentService extends BaseService {
     public void add(Student student);
     
     public void delete(Student student);
     public void deleteByID(String ID);
     public void deleteByExamineeNumber(String ExamineeNumber);
     
     public Student findStudentByID(String ID);
     public Student findStudentByExamineeNumber(long ExamineeNumber);
     public ArrayList<Student> findStudentByName(String name);
     public ArrayList<Student> findStudentByClass(String classes);
     public ArrayList<Student> findStudentByClasses(int classes);
     public ArrayList<Student> findStudentByMajor(Major major);
     public ArrayList<Student> findStudentScoreBelow(int score);
     public ArrayList<Student> findStudentScoreHigerThanScore(int score);
     public ArrayList<Student> findStudentScoreBetweenScore(int higerScore,int lowScore);
     
     
     public void changeStudentID(String ID);
     public void changeStudentExamineeNumber(long ExamineeNumber);
     public void changeStudentName(String name);
     public void changeStudentSex(Sex sex);
     public void changeStudentGrade(int grade);
     public void changeStudentClasses(int classes);
     public void changeStudentMajor(Major major);
     public void changeStudentPassword(String password);
     public void changeStudentScore(int score);
     
}

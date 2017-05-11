package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.Student;

public interface StudentMapper {
	int deleteByPrimaryKey(Long studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
   
    
    int deleteOne(Student student);  
    
    int deleteByID(long ID);
    
    int deleteByExamineeNumber(long examineenumber);
    
    int deleteByName(String name);
    
    int deleteByMajor(String major);
    
    int deleteByClass(int classes);
    
    int deleteByGrade(int grade);
    
    List<Student> selectAll();
    
    List<Student> selectByClass(int classes);
    
    List<Student> selectByName(String name);
    
    Student selectByStudentId(long studentID);
    
    Student selectByExamineeNumber(long examineeNumber);
    
    List<Student> selectByGrade(int grade);
    
    List<Student> selectByMajor(String major);
    
    List<Student> selectStudentScoreBelow(int score);
    
    List<Student> selectStudentScoreHiger(int score);
    
    List<Student> selectStudentScoreBetween(int higherScore , int lowScore);}
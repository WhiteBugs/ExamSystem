package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.Student;

import antlr.collections.List;

public interface StudentMapper {
    int insert(Student student);
    int insertSelective(Student student);
    
    int update(Student student);
    int updateSelective(Student student);
    
    int deleteOne(Student student);  
    int deleteByStudentId(long ID);
    int deleteByExamineeNumber(long examineenumber);
    int deleteByName(String name);
    int deleteByMajor(String major);
    int deleteByClass(int classes);
    int deleteByGrade(int grade);
    
    List selectAll();
    List selectByClass(int classes);
    List selectByName(String name);
    Student selectByStudentId(long studentID);
    Student selectByExamineeNumber(long examineeNumber);
    List selectByGrade(int grade);
    List selectByMajor(String major);
    List selectStudentScoreBelow(int score);
    List selectStudentScoreHiger(int score);
    List selectStudentScoreBetween(int higerScore , int lowScore);
}
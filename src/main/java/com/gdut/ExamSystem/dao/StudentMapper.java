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

	List selectAll();

	List selectByClass(int classes);

	List selectByName(String name);

	Student selectByStudentId(long studentID);

	Student selectByExamineeNumber(long examineeNumber);

	List selectByGrade(int grade);

	List selectByMajor(String major);
}
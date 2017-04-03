package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);
   
    Student getStudent(long studentId);
    
}
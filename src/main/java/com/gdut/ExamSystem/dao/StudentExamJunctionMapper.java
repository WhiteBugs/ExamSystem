package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.StudentExamJunction;

public interface StudentExamJunctionMapper {
    int insert(StudentExamJunction record);

    int insertSelective(StudentExamJunction record);
    
    int deleteOne(StudentExamJunction record);
}
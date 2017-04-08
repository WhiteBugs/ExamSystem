package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.Student;

public interface StudentMapper {
    int insert(Student student);

    int insertSelective(Student student);

    int deleteOne(Student student);
    Student selectOne(Student student);
    int update(Student student);

}
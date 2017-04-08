package com.gdut.ExamSystem.dao;


import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;

public interface TeacherMapper {
    int insert(TeacherWithBLOBs record);

    int insertSelective(TeacherWithBLOBs record);

    int delete(Teacher teacher);
    Teacher selectOne(Teacher teacher);
    int update(Teacher teacher); 
}
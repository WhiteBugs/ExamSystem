package com.gdut.ExamSystem.dao;


import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;

import antlr.collections.List;

public interface TeacherMapper {
    int insert(TeacherWithBLOBs record);

    int insertSelective(TeacherWithBLOBs record);

    List selectAll();
    int delete(Teacher teacher);
    Teacher selectOne(Teacher teacher);
    int update(Teacher teacher); 
}
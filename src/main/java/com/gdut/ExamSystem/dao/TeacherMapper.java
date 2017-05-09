package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;

public interface TeacherMapper {
    int deleteByPrimaryKey(String count);

    int insert(TeacherWithBLOBs record);

    int insertSelective(TeacherWithBLOBs record);

    TeacherWithBLOBs selectByPrimaryKey(String count);

    int updateByPrimaryKeySelective(TeacherWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TeacherWithBLOBs record);

    int updateByPrimaryKey(Teacher record);
    
    List<Teacher> selectAll();
 
}
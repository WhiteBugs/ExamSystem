package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;

public interface AdminstratorMapper {
    int deleteByPrimaryKey(String count);

    int insert(AdminstratorWithBLOBs record);

    int insertSelective(AdminstratorWithBLOBs record);

    AdminstratorWithBLOBs selectByPrimaryKey(String count);

    int updateByPrimaryKeySelective(AdminstratorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AdminstratorWithBLOBs record);

    int updateByPrimaryKey(Adminstrator record);
    
    List<Teacher> findAllTeacher();
    List<Student> findAllStudent();
}
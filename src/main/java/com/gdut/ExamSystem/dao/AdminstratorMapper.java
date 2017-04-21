package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;

import antlr.collections.List;

public interface AdminstratorMapper {
    int insert(AdminstratorWithBLOBs admin);
    int insertSelective(AdminstratorWithBLOBs admin);
    List findAllTeacher();
    List findAllStudent();
    int insert(Adminstrator admin);
    int insertSelective(Adminstrator admin);
    int delete(Adminstrator admin);
    Adminstrator selectOne(Adminstrator admin);
    int update(Adminstrator admin);
}
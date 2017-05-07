package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;

public interface AdminstratorMapper {
    int deleteByPrimaryKey(String count);

    int insert(AdminstratorWithBLOBs record);

    int insertSelective(AdminstratorWithBLOBs record);

    AdminstratorWithBLOBs selectByPrimaryKey(String count);

    int updateByPrimaryKeySelective(AdminstratorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AdminstratorWithBLOBs record);

    int updateByPrimaryKey(Adminstrator record);
    

    List findAllTeacher();
    List findAllStudent();
    int insert(Adminstrator admin);
    int insertSelective(Adminstrator admin);
    int delete(Adminstrator admin);
    Adminstrator selectOne(Adminstrator admin);
    int update(Adminstrator admin);
}
package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;

public interface AdminstratorMapper {
    int insert(AdminstratorWithBLOBs admin);

    int insertSelective(AdminstratorWithBLOBs admin);
    
    int insert(Adminstrator admin);
    int insertSelective(Adminstrator admin);
    int delete(Adminstrator admin);
    Adminstrator selectOne(Adminstrator admin);
    int update(Adminstrator admin);
}
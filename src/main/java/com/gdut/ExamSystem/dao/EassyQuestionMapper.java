package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.EassyQuestion;

public interface EassyQuestionMapper {
    int deleteByPrimaryKey(Integer eassyQuestionId);

    int insert(EassyQuestion record);

    int insertSelective(EassyQuestion record);

    EassyQuestion selectByPrimaryKey(Integer eassyQuestionId);

    int updateByPrimaryKeySelective(EassyQuestion record);

    int updateByPrimaryKeyWithBLOBs(EassyQuestion record);
    
    List<EassyQuestion> selectAll();
}
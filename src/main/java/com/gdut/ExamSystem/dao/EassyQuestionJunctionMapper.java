package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.EassyQuestionJunction;
import com.gdut.ExamSystem.model.EassyQuestionJunctionKey;

public interface EassyQuestionJunctionMapper {
    int deleteByPrimaryKey(EassyQuestionJunctionKey key);

    int insert(EassyQuestionJunction record);

    int insertSelective(EassyQuestionJunction record);

    EassyQuestionJunction selectByPrimaryKey(EassyQuestionJunctionKey key);

    List<EassyQuestionJunction> findAllEassyQuestionOfExam(String examID);
    
    int updateByPrimaryKeySelective(EassyQuestionJunction record);

    int updateByPrimaryKey(EassyQuestionJunction record);
    
    int findQuestionId(String examId, int order);
}
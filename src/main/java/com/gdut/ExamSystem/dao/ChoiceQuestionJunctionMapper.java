package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.ChoiceQuestionJunction;
import com.gdut.ExamSystem.model.ChoiceQuestionJunctionKey;

public interface ChoiceQuestionJunctionMapper {
    int deleteByPrimaryKey(ChoiceQuestionJunctionKey key);

    int insert(ChoiceQuestionJunction record);

    int insertSelective(ChoiceQuestionJunction record);
    
    List<ChoiceQuestionJunction> findAllChoiceQuestionOfExam(String examID);

    ChoiceQuestionJunction selectByPrimaryKey(ChoiceQuestionJunctionKey key);

    int updateByPrimaryKeySelective(ChoiceQuestionJunction record);

    int updateByPrimaryKey(ChoiceQuestionJunction record);
    
    int findQuestionId(String examId, int order);
}
package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.EassyQuestionJunction;
import com.gdut.ExamSystem.model.EassyQuestionJunctionKey;

public interface EassyQuestionJunctionMapper {
    int deleteByPrimaryKey(EassyQuestionJunctionKey key);

    int insert(EassyQuestionJunction record);

    int insertSelective(EassyQuestionJunction record);

    EassyQuestionJunction selectByPrimaryKey(EassyQuestionJunctionKey key);

    int updateByPrimaryKeySelective(EassyQuestionJunction record);

    int updateByPrimaryKey(EassyQuestionJunction record);
}
package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.TrueFalseQuestionJunction;
import com.gdut.ExamSystem.model.TrueFalseQuestionJunctionKey;

public interface TrueFalseQuestionJunctionMapper {
    int deleteByPrimaryKey(TrueFalseQuestionJunctionKey key);

    int insert(TrueFalseQuestionJunction record);

    int insertSelective(TrueFalseQuestionJunction record);

    TrueFalseQuestionJunction selectByPrimaryKey(TrueFalseQuestionJunctionKey key);

    int updateByPrimaryKeySelective(TrueFalseQuestionJunction record);

    int updateByPrimaryKey(TrueFalseQuestionJunction record);
}
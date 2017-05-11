package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.ChoiceQuestionJunction;
import com.gdut.ExamSystem.model.ChoiceQuestionJunctionKey;

public interface ChoiceQuestionJunctionMapper {
    int deleteByPrimaryKey(ChoiceQuestionJunctionKey key);

    int insert(ChoiceQuestionJunction record);

    int insertSelective(ChoiceQuestionJunction record);

    ChoiceQuestionJunction selectByPrimaryKey(ChoiceQuestionJunctionKey key);

    int updateByPrimaryKeySelective(ChoiceQuestionJunction record);

    int updateByPrimaryKey(ChoiceQuestionJunction record);
}
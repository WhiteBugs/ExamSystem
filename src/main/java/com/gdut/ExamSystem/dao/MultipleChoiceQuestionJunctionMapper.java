package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.MultipleChoiceQuestionJunction;
import com.gdut.ExamSystem.model.MultipleChoiceQuestionJunctionKey;

public interface MultipleChoiceQuestionJunctionMapper {
    int deleteByPrimaryKey(MultipleChoiceQuestionJunctionKey key);

    int insert(MultipleChoiceQuestionJunction record);

    int insertSelective(MultipleChoiceQuestionJunction record);

    MultipleChoiceQuestionJunction selectByPrimaryKey(MultipleChoiceQuestionJunctionKey key);

    int updateByPrimaryKeySelective(MultipleChoiceQuestionJunction record);

    int updateByPrimaryKey(MultipleChoiceQuestionJunction record);
}
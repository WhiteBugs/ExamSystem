package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.ChoiceQuestionJunction;

public interface ChoiceQuestionJunctionMapper {
    int insert(ChoiceQuestionJunction record);

    int insertSelective(ChoiceQuestionJunction record);
}
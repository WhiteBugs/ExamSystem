package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.EassyQuestionJunction;

public interface EassyQuestionJunctionMapper {
    int insert(EassyQuestionJunction record);

    int insertSelective(EassyQuestionJunction record);
}
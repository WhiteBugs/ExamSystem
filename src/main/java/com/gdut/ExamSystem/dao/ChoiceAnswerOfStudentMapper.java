package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.ChoiceAnswerOfStudent;

public interface ChoiceAnswerOfStudentMapper {
    int insert(ChoiceAnswerOfStudent record);

    int insertSelective(ChoiceAnswerOfStudent record);
}
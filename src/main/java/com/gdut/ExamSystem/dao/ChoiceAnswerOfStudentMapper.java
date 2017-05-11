package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.ChoiceAnswerOfStudent;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudentKey;

public interface ChoiceAnswerOfStudentMapper {
    int deleteByPrimaryKey(ChoiceAnswerOfStudentKey key);

    int insert(ChoiceAnswerOfStudent record);

    int insertSelective(ChoiceAnswerOfStudent record);

    ChoiceAnswerOfStudent selectByPrimaryKey(ChoiceAnswerOfStudentKey key);

    int updateByPrimaryKeySelective(ChoiceAnswerOfStudent record);

    int updateByPrimaryKey(ChoiceAnswerOfStudent record);
}
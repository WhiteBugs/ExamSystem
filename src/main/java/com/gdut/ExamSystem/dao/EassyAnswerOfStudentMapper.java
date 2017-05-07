package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.EassyAnswerOfStudent;

public interface EassyAnswerOfStudentMapper {
    int insert(EassyAnswerOfStudent record);

    int insertSelective(EassyAnswerOfStudent record);
}
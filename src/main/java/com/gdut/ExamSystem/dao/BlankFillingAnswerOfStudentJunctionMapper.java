package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunction;

public interface BlankFillingAnswerOfStudentJunctionMapper {
    int insert(BlankFillingAnswerOfStudentJunction record);

    int insertSelective(BlankFillingAnswerOfStudentJunction record);
}
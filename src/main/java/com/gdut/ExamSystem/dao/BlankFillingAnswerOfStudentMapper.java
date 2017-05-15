package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudent;

public interface BlankFillingAnswerOfStudentMapper {
    int deleteByPrimaryKey(Integer blankFillingAnswerId);

    int insert(BlankFillingAnswerOfStudent record);

    int insertSelective(BlankFillingAnswerOfStudent record);

    BlankFillingAnswerOfStudent selectByPrimaryKey(Integer blankFillingAnswerId);

    int updateByPrimaryKeySelective(BlankFillingAnswerOfStudent record);

    int updateByPrimaryKey(BlankFillingAnswerOfStudent record);
}
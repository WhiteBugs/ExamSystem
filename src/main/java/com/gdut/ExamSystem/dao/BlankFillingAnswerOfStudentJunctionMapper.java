package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunction;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunctionKey;

public interface BlankFillingAnswerOfStudentJunctionMapper {
    int deleteByPrimaryKey(BlankFillingAnswerOfStudentJunctionKey key);

    int insert(BlankFillingAnswerOfStudentJunction record);

    int insertSelective(BlankFillingAnswerOfStudentJunction record);

    BlankFillingAnswerOfStudentJunction selectByPrimaryKey(BlankFillingAnswerOfStudentJunctionKey key);

    int updateByPrimaryKeySelective(BlankFillingAnswerOfStudentJunction record);

    int updateByPrimaryKey(BlankFillingAnswerOfStudentJunction record);
}
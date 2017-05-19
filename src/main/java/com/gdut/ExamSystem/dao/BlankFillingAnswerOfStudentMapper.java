package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudent;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentKey;

public interface BlankFillingAnswerOfStudentMapper {
    int deleteByPrimaryKey(BlankFillingAnswerOfStudentKey key);
    
    int deleteByAnswerId(Integer blankFillingAnswerId);

    int insert(BlankFillingAnswerOfStudent record);
    
    List<String> selectByAnswerId(Integer blankFillingAnswerId);

    int insertSelective(BlankFillingAnswerOfStudent record);

    BlankFillingAnswerOfStudent selectByPrimaryKey(BlankFillingAnswerOfStudentKey key);

    int updateByPrimaryKeySelective(BlankFillingAnswerOfStudent record);

    int updateByPrimaryKey(BlankFillingAnswerOfStudent record);
}
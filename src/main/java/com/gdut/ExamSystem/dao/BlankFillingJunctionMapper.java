package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.BlankFillingJunction;
import com.gdut.ExamSystem.model.BlankFillingJunctionKey;

public interface BlankFillingJunctionMapper {
    int deleteByPrimaryKey(BlankFillingJunctionKey key);

    int insert(BlankFillingJunction record);

    int insertSelective(BlankFillingJunction record);

    BlankFillingJunction selectByPrimaryKey(BlankFillingJunctionKey key);

    List<BlankFillingJunction> findAllBlankFillingQuestionOfExam(String examID);
    
    int updateByPrimaryKeySelective(BlankFillingJunction record);

    int updateByPrimaryKey(BlankFillingJunction record);
}
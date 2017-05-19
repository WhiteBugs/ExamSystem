package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.BlankFillingQuestion;

public interface BlankFillingQuestionMapper {
    int deleteByPrimaryKey(Integer blankFillingQuestionId);

    int insert(BlankFillingQuestion record);

    int insertSelective(BlankFillingQuestion record);

    BlankFillingQuestion selectByPrimaryKey(Integer blankFillingQuestionId);

    List<BlankFillingQuestion> selectAll();
    
    int updateByPrimaryKeySelective(BlankFillingQuestion record);

    int updateByPrimaryKeyWithBLOBs(BlankFillingQuestion record);
}
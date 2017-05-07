package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingQuestion;

public interface BlankFillingQuestionMapper {
    int deleteByPrimaryKey(Integer blankFillingQuestionId);

    int insert(BlankFillingQuestion record);

    int insertSelective(BlankFillingQuestion record);

    BlankFillingQuestion selectByPrimaryKey(Integer blankFillingQuestionId);

    int updateByPrimaryKeySelective(BlankFillingQuestion record);

    int updateByPrimaryKeyWithBLOBs(BlankFillingQuestion record);
}
package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingAnswer;

public interface BlankFillingAnswerMapper {
    int deleteByPrimaryKey(Integer blankFillingQuestionId);

    int insert(BlankFillingAnswer record);

    int insertSelective(BlankFillingAnswer record);

    BlankFillingAnswer selectByPrimaryKey(Integer blankFillingQuestionId);

    int updateByPrimaryKeySelective(BlankFillingAnswer record);

    int updateByPrimaryKeyWithBLOBs(BlankFillingAnswer record);

    int updateByPrimaryKey(BlankFillingAnswer record);
}
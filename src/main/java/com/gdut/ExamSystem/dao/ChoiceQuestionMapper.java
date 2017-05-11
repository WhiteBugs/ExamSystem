package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.ChoiceQuestion;

public interface ChoiceQuestionMapper {
    int deleteByPrimaryKey(Integer choiceQuestionId);

    int insert(ChoiceQuestion record);

    ChoiceQuestion selectByPrimaryKey(Integer choiceQuestionId);

    int updateByPrimaryKeySelective(ChoiceQuestion record);

    int updateByPrimaryKeyWithBLOBs(ChoiceQuestion record);

    int updateByPrimaryKey(ChoiceQuestion record);
}
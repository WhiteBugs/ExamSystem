package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.ChoiceQuestion;

public interface ChoiceQuestionMapper {
    int deleteByPrimaryKey(Integer choiceQuestionId);

    int insert(ChoiceQuestion record);

    ChoiceQuestion selectByPrimaryKey(Integer choiceQuestionId);

    List<ChoiceQuestion> selectALL();
    
    int updateByPrimaryKeySelective(ChoiceQuestion record);

    int updateByPrimaryKeyWithBLOBs(ChoiceQuestion record);

    int updateByPrimaryKey(ChoiceQuestion record);
}
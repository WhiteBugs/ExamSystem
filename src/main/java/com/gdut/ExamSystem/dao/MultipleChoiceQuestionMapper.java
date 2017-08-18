package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.MultipleChoiceQuestion;

public interface MultipleChoiceQuestionMapper {
    int deleteByPrimaryKey(Integer multipleChoiceQuestionId);

    int insert(MultipleChoiceQuestion record);

    int insertSelective(MultipleChoiceQuestion record);

    MultipleChoiceQuestion selectByPrimaryKey(Integer multipleChoiceQuestionId);

    int updateByPrimaryKeySelective(MultipleChoiceQuestion record);

    int updateByPrimaryKeyWithBLOBs(MultipleChoiceQuestion record);

    int updateByPrimaryKey(MultipleChoiceQuestion record);
}
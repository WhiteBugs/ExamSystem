package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.TrueFalseQuestion;

public interface TrueFalseQuestionMapper {
    int deleteByPrimaryKey(Integer trueFalseQuestionId);

    int insert(TrueFalseQuestion record);

    int insertSelective(TrueFalseQuestion record);

    TrueFalseQuestion selectByPrimaryKey(Integer trueFalseQuestionId);

    int updateByPrimaryKeySelective(TrueFalseQuestion record);

    int updateByPrimaryKey(TrueFalseQuestion record);
}
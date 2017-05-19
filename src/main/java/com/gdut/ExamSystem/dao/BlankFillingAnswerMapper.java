package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.BlankFillingAnswer;
import com.gdut.ExamSystem.model.BlankFillingAnswerKey;

public interface BlankFillingAnswerMapper {
    int deleteByPrimaryKey(BlankFillingAnswerKey key);

    int insert(BlankFillingAnswer record);

    int insertSelective(BlankFillingAnswer record);

    BlankFillingAnswer selectByPrimaryKey(BlankFillingAnswerKey key);
    
    List<BlankFillingAnswer> selectByQuestionID(int blankFillingQuestionId);

    int updateByPrimaryKeySelective(BlankFillingAnswer record);

    int updateByPrimaryKeyWithBLOBs(BlankFillingAnswer record);
    
    int updateByPrimaryKey(BlankFillingAnswer record);
}
package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.BlankFillingAnswer;

public interface BlankFillingAnswerMapper {
    int insert(BlankFillingAnswer record);

    int insertSelective(BlankFillingAnswer record);
}
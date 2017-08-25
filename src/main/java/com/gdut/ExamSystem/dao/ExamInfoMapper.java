package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.ExamInfo;
import com.gdut.ExamSystem.model.ExamInfoKey;

public interface ExamInfoMapper {
    int deleteByPrimaryKey(ExamInfoKey key);

    int insert(ExamInfo record);

    int insertSelective(ExamInfo record);

    ExamInfo selectByPrimaryKey(ExamInfoKey key);

    int updateByPrimaryKeySelective(ExamInfo record);

    int updateByPrimaryKey(ExamInfo record);
}
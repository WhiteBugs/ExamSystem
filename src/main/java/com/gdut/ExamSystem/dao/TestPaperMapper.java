package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.model.TestPaperKey;

public interface TestPaperMapper {
    int deleteByPrimaryKey(TestPaperKey key);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    TestPaper selectByPrimaryKey(TestPaperKey key);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
}
package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.TestPaper;

public interface TestPaperMapper {
    int deleteByPrimaryKey(Integer examId);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    TestPaper selectByPrimaryKey(Integer examId);
    
    List<TestPaper> selectByTeacherCount(String count);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKeyWithBLOBs(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
}
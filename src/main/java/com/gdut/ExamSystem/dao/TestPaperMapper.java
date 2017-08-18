package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.TestPaper;

public interface TestPaperMapper {
    int deleteByPrimaryKey(String examId);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    TestPaper selectByPrimaryKey(String examId);
    
    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKeyWithBLOBs(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
    
    List<TestPaper> findAllExam();

}
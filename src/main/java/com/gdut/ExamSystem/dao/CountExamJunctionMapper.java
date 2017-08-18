package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.CountExamJunctionKey;

public interface CountExamJunctionMapper {
    int deleteByPrimaryKey(CountExamJunctionKey key);

    int insert(CountExamJunctionKey record);

    int insertSelective(CountExamJunctionKey record);
    
    List<String> findAllExamByTeacherCount(String counts);
    
    List<String> findAllTeacherCountsByExam(String examId);

}
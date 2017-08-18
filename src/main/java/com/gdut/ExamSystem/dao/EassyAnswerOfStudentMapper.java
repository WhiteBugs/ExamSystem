package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.EassyAnswerOfStudent;
import com.gdut.ExamSystem.model.EassyAnswerOfStudentKey;

public interface EassyAnswerOfStudentMapper {
    int deleteByPrimaryKey(EassyAnswerOfStudentKey key);

    int insert(EassyAnswerOfStudent record);

    int insertSelective(EassyAnswerOfStudent record);

    EassyAnswerOfStudent selectByPrimaryKey(EassyAnswerOfStudentKey key);

    int updateByPrimaryKeySelective(EassyAnswerOfStudent record);

    int updateByPrimaryKeyWithBLOBs(EassyAnswerOfStudent record);

    int updateByPrimaryKey(EassyAnswerOfStudent record);
    
    List<EassyAnswerOfStudent> selectStudentAllEassyAnswer(String examId, long studentId);
    
}
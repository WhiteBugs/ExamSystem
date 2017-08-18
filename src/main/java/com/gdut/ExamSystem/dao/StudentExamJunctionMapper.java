package com.gdut.ExamSystem.dao;

import java.util.List;

import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;

public interface StudentExamJunctionMapper {
    int deleteByPrimaryKey(StudentExamJunctionKey key);

    int insert(StudentExamJunction record);

    int insertSelective(StudentExamJunction record);

    StudentExamJunction selectByPrimaryKey(StudentExamJunctionKey key);

    int updateByPrimaryKeySelective(StudentExamJunction record);

    int updateByPrimaryKey(StudentExamJunction record);
    
    List<Long> findStudentScoreBelow(String examId, int score);
    
    List<Long> findStudentScoreHiger(String examId, int score);
    
    List<Long> findStudentScoreBetween(String examId, int highScore, int lowScore);

	int deleteByExamID(String ExamID);

	List<Long> findAllStudentIDByExamID(String examID);

	Long findOneStudentIDInExam(StudentExamJunctionKey key);

	List<StudentExamJunction> findStudentAllExamJunction(long studentID);
    
}
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
    
    List<Long> findStudentScoreBelow(int examId, int score);
    
    List<Long> findStudentScoreHiger(int examId, int score);
    
    List<Long> findStudentScoreBetween(int examId, int highScore, int lowScore);

	int deleteByExamID(int ExamID);

	List<Long> findAllStudentIDByExamID(int examID);

	Long findOneStudentIDInExam(StudentExamJunctionKey key);

	List<StudentExamJunction> findStudentAllExamJunction(long studentID);
    
}
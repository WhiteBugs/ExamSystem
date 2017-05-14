package com.gdut.ExamSystem.dao;

import java.util.List;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;

public interface StudentExamJunctionMapper {
	int insert( StudentExamJunctionKey record);

    int insertSelective( StudentExamJunctionKey record);
    
    int deleteByExamID ( int examID);
	
    List<Long> findAllStudentIDByExamID( int examID );
    
    List<Integer> findStudentAllExam(long studentID);
    
    Long findOneStudentIDInExam(StudentExamJunctionKey record);

	int deleteByPrimaryKey(StudentExamJunctionKey key);
}
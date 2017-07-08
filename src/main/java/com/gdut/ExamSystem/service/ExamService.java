package com.gdut.ExamSystem.service;

import java.util.List;

import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.TestPaper;


public interface ExamService {
	List<Integer> findChoiceQuestionOfExam(int examID);
	
	List<Integer> findBlankFillingQuestionOfExam(int examID);
	
	List<Integer> findEassyQuestionOfExam(int examID);
	
	int addExam(TestPaper testPaper);
	
	List<ChoiceQuestion> findAllChoiceQuestion();
	
	List<BlankFillingQuestion> findAllBlankFillingQuestion();
	
	List<EassyQuestion> findAllEassyQuestion();
	
	String generateAnswer(int examID);
	
	int findStudentScore(int examId, long studentId);
	
	TestPaper findExamById(int examid);
	
    List<Long> findStudentScoreBelow(int examId, int score);
    
    List<Long> findStudentScoreHiger(int examId, int score);
    
    List<Long> findStudentScoreBetween(int examId, int highScore, int lowScore);
    
    List<StudentExamJunction> findStudentAllExamJunction(long studentId);
    
    List<TestPaper> findAllExam();
    
    List<TestPaper> findAllExamByTeacherCount(String count);
}
 
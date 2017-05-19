package com.gdut.ExamSystem.service;


import java.util.List;

import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;

public interface TeacherService {
	
	public int addTeacherCount(TeacherWithBLOBs teacher);
	
	public int deleteTeacherByCount(String count);
	
	public TeacherWithBLOBs findTeacherByCount(String count);
	
	public int changeTeacherPassword(String count,String password);
	
	public int changeTeacherSafeQuesTion(String count,String question);
	
	public int changeTeacherSafeAnswer(String count,String answer);
	
	public List<TestPaper> findExam(String count);
	
	public int addChoiceQuestionOfExam(int examId, int  choiceQuestionId, int order);
	
	public int addBlankFillingQuestionOfExam(int examId, int BlankFillingQuestionId, int order);
	
	public int addEassyQuestionOfExam(int examId, int eassyQuestionId, int order);
	
	public int updateChoiceQuestionScoreOfStudent(int examId, long studentId, int orders, int score );
	
	public int updateBlankFillingQuestionScoreOfStudent(int examId, long studentId, int orders, int score);
	
	public int updateEassyQuestionScoreOfStudent(int examId, long studentId, int orders, int score);
	
	public int getChoiceQuestionScoreOfStudent(int examId, long studentId);
	
	public int getBlankFillingQuestionScoreOfStudent(int examId, long studentId);
	
	public int getEassyQuestionScoreOfStudent(int examId, long studentId);
	
	public int updateAnswerOfChoiceQuestion(int choiceQuestionId,String answer);
	
	public int updateAnswerOfBlankFillingQuestion(int blankFillingQuestionId, int order, String answer);
	
	public int updateAnswerOfEassyQuestion(int eassyQuestionId, String answer);
	
}

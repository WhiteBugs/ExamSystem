package com.gdut.ExamSystem.service;


import java.util.List;

import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.BlankFillingQuestionWithAnswers;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;

public interface TeacherService {
	
	public int addTeacherCount(TeacherWithBLOBs teacher);
	
	public int deleteTeacherByCount(String count);
	
	public TeacherWithBLOBs findTeacherByCount(String count);
	
	public int changeTeacherPassword(String count,String password);
	
	public int changeTeacherSafeQuesTion(String count,String question);
	
	public int changeTeacherSafeAnswer(String count,String answer);
	
	public List<Teacher> findAllTeacher();
	
	public int addChoiceQuestionOfExam(String examId, int  choiceQuestionId, int order);
	
	public int addBlankFillingQuestionOfExam(String examId, int BlankFillingQuestionId, int order);
	
	public int addEassyQuestionOfExam(String examId, int eassyQuestionId, int order);
	
	public int updateChoiceQuestionScoreOfStudent(String examId, long studentId, int orders, int score );
	
	public int updateBlankFillingQuestionScoreOfStudent(String examId, long studentId, int orders, int score);
	
	public int updateEassyQuestionScoreOfStudent(String examId, long studentId, int orders, int score);
	
	public int getChoiceQuestionScoreOfStudent(String examId, long studentId);
	
	public int getBlankFillingQuestionScoreOfStudent(String examId, long studentId);
	
	public int getEassyQuestionScoreOfStudent(String examId, long studentId);
	
	public int updateAnswerOfChoiceQuestion(int choiceQuestionId,String answer);
	
	public int updateAnswerOfBlankFillingQuestion(int blankFillingQuestionId, int order, String answer);
	
	public int updateAnswerOfEassyQuestion(int eassyQuestionId, String answer);
	
	public int addChoiceQuestionIntoDB(ChoiceQuestion choiceQuestion);
	
	public int addBlankFillingQuestionIntoDB(BlankFillingQuestion blankFillingQuestion, String[] answers);
	
	public int addEassyQuestionIntoDB(EassyQuestion eassyQuestion);
	
	public ChoiceQuestion findChoiceQuestionById(int id);
	
	public BlankFillingQuestionWithAnswers findBlankFillingQuestionById(int id);
	
	public EassyQuestion findEassyQuestionById(int id);
	
	public int updateChoiceQuestion(ChoiceQuestion choiceQuestion);
	
	public int updateBlankFillingQuestion(BlankFillingQuestion blankFillingQuestion);
	
	public int updateEassyQuestion(EassyQuestion eassyQuestion);
	
	
}

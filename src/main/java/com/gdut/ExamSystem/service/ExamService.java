package com.gdut.ExamSystem.service;

import java.util.List;
import java.util.Map;

import com.gdut.ExamSystem.enums.QuestionType;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.BlankFillingQuestionWithAnswers;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.ExamInfo;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.TestPaper;


public interface ExamService {
	List<ChoiceQuestion> findChoiceQuestionOfExam(String examID);
	
	List<BlankFillingQuestionWithAnswers> findBlankFillingQuestionOfExam(String examID);
	
	List<EassyQuestion> findEassyQuestionOfExam(String examID);
	
	int addExam(TestPaper testPaper);
	
	int addStudentOfExam(String examId, long studentId);
	
	int addQuestionScore(ExamInfo examInfo);
	
	int changeStudentScore(String examId, long studentId, int score);
	
	List<Long> findAllStudentIdByExamId(String examId);
	
	List<ChoiceQuestion> findAllChoiceQuestion();
	
	List<BlankFillingQuestionWithAnswers> findAllBlankFillingQuestion();
	
	List<EassyQuestion> findAllEassyQuestion();
	
	String generateAnswer(String examID);
	
	int findStudentScore(String examId, long studentId);
	
	ExamInfo findQuestionScoreOfExam(String examId, String questionType);
	
	TestPaper findExamById(String examid);
	
    List<Long> findStudentScoreBelow(String examId, int score);
    
    List<Long> findStudentScoreHiger(String examId, int score);
    
    List<Long> findStudentScoreBetween(String examId, int highScore, int lowScore);
    
    Map findQuestionAnswer(String examId, QuestionType type);
    
    List findQuestionWithStudentAnswer(String examId, String studentId,  QuestionType type);
    
    List<StudentExamJunction> findStudentAllExamJunction(long studentId);
    
    List<TestPaper> findAllExam();
    
    List<TestPaper> findAllExamByTeacherCount(String count);
    
    int findQuestionIdOfExam(String examId, int order, QuestionType type);
}
 
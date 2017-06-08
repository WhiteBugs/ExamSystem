package com.gdut.ExamSystem.service;

import java.util.List;

import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
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
	TestPaper findExamById(int examid);
}
 
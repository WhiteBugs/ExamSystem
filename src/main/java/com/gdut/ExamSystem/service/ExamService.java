package com.gdut.ExamSystem.service;

import java.util.List;

import com.gdut.ExamSystem.model.TestPaper;


public interface ExamService {
	List<Integer> findChoiceQuestion(int examID);
	List<Integer> findBlankFillingQuestion(int examID);
	List<Integer> findEassyQuestion(int examID);
	int addExam(TestPaper testPaper);
}
 
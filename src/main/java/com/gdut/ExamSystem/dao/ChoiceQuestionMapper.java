package com.gdut.ExamSystem.dao;

import com.gdut.ExamSystem.model.ChoiceQuestion;

public interface ChoiceQuestionMapper {
	int insert(ChoiceQuestion choiceQuestion);
	int findByNumber(int number);
	int deleteByNumber(int number);
	int changerQuestion(ChoiceQuestion choiceQuestion);
}

package com.gdut.ExamSystem.serviceImpl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdut.ExamSystem.dao.BlankFillingJunctionMapper;
import com.gdut.ExamSystem.dao.ChoiceQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.EassyQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.ExamService;

@Service("ExamService")
public class ExamServiceImp implements ExamService {
	@Resource(name="TestPaperMapper")
	private TestPaperMapper testPaperMapper;
	
	@Resource(name="ChoiceQuestionJunctionMapper")
	private ChoiceQuestionJunctionMapper choiceQuestionJunctionMapper;

	@Resource(name="BlankFillingJunctionMapper")
	private BlankFillingJunctionMapper blankFillingJunctionMapper;
	
	@Resource(name="EassyQuestionJunctionMapper")
	private EassyQuestionJunctionMapper eassyQuestionJunction;
	
	@Override
	public List<Integer> findChoiceQuestion(int examID) {
		return choiceQuestionJunctionMapper.findAllChoiceQuestionOfExam(examID);
	}

	@Override
	public List<Integer> findBlankFillingQuestion(int examID) {
		return blankFillingJunctionMapper.findAllBlankFillingQuestionOfExam(examID);
	}

	@Override
	public List<Integer> findEassyQuestion(int examID) {
		return eassyQuestionJunction.findAllEassyQuestionOfExam(examID);
	}

	@Override
	public int addExam(TestPaper testPaper) {
		return testPaperMapper.insert(testPaper);
	}

}

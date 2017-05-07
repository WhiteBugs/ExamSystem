package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.dao.ChoiceQuestionMapper;


public class ChoiceQuestionImp implements ChoiceQuestionMapper {
	private static final Logger logger = LoggerFactory.getLogger(AdminDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	@Override
	public int deleteByPrimaryKey(Integer choiceQuestionId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insertSelective(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ChoiceQuestion selectByPrimaryKey(Integer choiceQuestionId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateByPrimaryKeySelective(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByPrimaryKeyWithBLOBs(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByPrimaryKey(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int findByNumber(int number) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteByNumber(int number) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int changerQuestion(ChoiceQuestion choiceQuestion) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}

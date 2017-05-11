package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.EassyQuestionJunctionMapper;
import com.gdut.ExamSystem.model.EassyQuestionJunction;
import com.gdut.ExamSystem.model.EassyQuestionJunctionKey;

public class EassyQuestionJunctionImp implements EassyQuestionJunctionMapper {
	private static final Logger logger = LoggerFactory.getLogger(EassyQuestionJunctionImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.EassyQuestionJunctionMapper.";
	
	@Override
	public int insert(EassyQuestionJunction record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(EassyQuestionJunction record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public int deleteByPrimaryKey(EassyQuestionJunctionKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public EassyQuestionJunction selectByPrimaryKey(EassyQuestionJunctionKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

	@Override
	public int updateByPrimaryKeySelective(EassyQuestionJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(EassyQuestionJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

}

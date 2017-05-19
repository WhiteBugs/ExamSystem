package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.EassyQuestionMapper;
import com.gdut.ExamSystem.model.EassyQuestion;

@Repository("EassyQuestionMapper")
public class EassyQuestionImp implements EassyQuestionMapper {
	private static final Logger logger = LoggerFactory.getLogger(EassyQuestionImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.EassyQuestionMapper.";
	@Override
	public int deleteByPrimaryKey(Integer eassyQuestionId) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",eassyQuestionId);
	}
	@Override
	public int insert(EassyQuestion record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}
	@Override
	public int insertSelective(EassyQuestion record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}
	@Override
	public EassyQuestion selectByPrimaryKey(Integer eassyQuestionId) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",eassyQuestionId);
	}
	@Override
	public int updateByPrimaryKeySelective(EassyQuestion record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}
	@Override
	public int updateByPrimaryKeyWithBLOBs(EassyQuestion record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}
	@Override
	public List<EassyQuestion> selectAll() {
		return sqlSession.selectList(NAME_SPACE+"selectAll");
	}
}

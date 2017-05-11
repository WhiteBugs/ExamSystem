package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.model.TestPaperKey;

public class TestPaperImp implements TestPaperMapper {
	private static final Logger logger = LoggerFactory.getLogger(TestPaperImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.TestPaperMapper.";
	
	@Override
	public int deleteByPrimaryKey(TestPaperKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public int insert(TestPaper record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(TestPaper record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public TestPaper selectByPrimaryKey(TestPaperKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

	@Override
	public int updateByPrimaryKeySelective(TestPaper record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(TestPaper record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

}

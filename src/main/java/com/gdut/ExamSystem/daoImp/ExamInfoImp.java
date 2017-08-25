package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.ExamInfoMapper;
import com.gdut.ExamSystem.model.ExamInfo;
import com.gdut.ExamSystem.model.ExamInfoKey;

@Repository("ExamInfoMapper")
public class ExamInfoImp implements ExamInfoMapper {
	private static final Logger logger = LoggerFactory.getLogger(ExamInfoImp.class);
	
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.ExamInfoMapper.";
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;


	@Override
	public int insert(ExamInfo record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(ExamInfo record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}


	@Override
	public int updateByPrimaryKeySelective(ExamInfo record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(ExamInfo record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public int deleteByPrimaryKey(ExamInfoKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public ExamInfo selectByPrimaryKey(ExamInfoKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

}

package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingAnswerMapper;
import com.gdut.ExamSystem.model.BlankFillingAnswer;
import com.gdut.ExamSystem.model.BlankFillingAnswerKey;

@Repository("BlankFillingAnswerMapper")
public class BlankFillingAnswerMapperImp implements BlankFillingAnswerMapper {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.BlankFillingAnswerMapper.";
	
	@Override
	public int insert(BlankFillingAnswer record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(BlankFillingAnswer record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingAnswer record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(BlankFillingAnswer record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}

	@Override
	public int updateByPrimaryKey(BlankFillingAnswer record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public int deleteByPrimaryKey(BlankFillingAnswerKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public BlankFillingAnswer selectByPrimaryKey(BlankFillingAnswerKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

	@Override
	public List<BlankFillingAnswer> selectByQuestionID(int blankFillingQuestionId) {
		return sqlSession.selectList(NAME_SPACE+"selectByQuestionID",blankFillingQuestionId);
	}

}

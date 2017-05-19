package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentMapper;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudent;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentKey;

@Repository("BlankFillingAnswerOfStudentMapper")
public class BlankFillingAnswerOfStudentMapperImp implements BlankFillingAnswerOfStudentMapper {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentMapper.";
	
	@Override
	public int insert(BlankFillingAnswerOfStudent record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(BlankFillingAnswerOfStudent record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingAnswerOfStudent record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(BlankFillingAnswerOfStudent record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public int deleteByPrimaryKey(BlankFillingAnswerOfStudentKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public int deleteByAnswerId(Integer blankFillingAnswerId) {
		return sqlSession.delete(NAME_SPACE+"deleteByAnswerId",blankFillingAnswerId);
	}

	@Override
	public List<String> selectByAnswerId(Integer blankFillingAnswerId) {
		return sqlSession.selectList(NAME_SPACE+"selectByAnswerId",blankFillingAnswerId);
	}

	@Override
	public BlankFillingAnswerOfStudent selectByPrimaryKey(BlankFillingAnswerOfStudentKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

}

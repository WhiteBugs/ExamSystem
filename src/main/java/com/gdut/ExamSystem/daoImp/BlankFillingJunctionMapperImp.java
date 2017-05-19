package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingJunctionMapper;
import com.gdut.ExamSystem.model.BlankFillingJunction;
import com.gdut.ExamSystem.model.BlankFillingJunctionKey;

@Repository("BlankFillingJunctionMapper")
public class BlankFillingJunctionMapperImp implements BlankFillingJunctionMapper {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.BlankFillingJunctionMapper.";
	
	@Override
	public int deleteByPrimaryKey(BlankFillingJunctionKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public int insert(BlankFillingJunction record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(BlankFillingJunction record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public BlankFillingJunction selectByPrimaryKey(BlankFillingJunctionKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

	@Override
	public List<Integer> findAllBlankFillingQuestionOfExam(int examID) {
		return sqlSession.selectList(NAME_SPACE+"findAllBlankFillingQuestionOfExam",examID);
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(BlankFillingJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

}

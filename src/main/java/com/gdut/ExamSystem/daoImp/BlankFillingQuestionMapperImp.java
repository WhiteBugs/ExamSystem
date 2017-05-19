package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingQuestionMapper;
import com.gdut.ExamSystem.model.BlankFillingQuestion;

@Repository("BlankFillingQuestionMapper")
public class BlankFillingQuestionMapperImp implements BlankFillingQuestionMapper {
	private static final Logger logger = LoggerFactory.getLogger(BlankFillingQuestionMapperImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE="com.gdut.ExamSystem.dao.BlankFillingQuestionMapper.";

	@Override
	public int deleteByPrimaryKey(Integer blankFillingQuestionId) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",blankFillingQuestionId);
	}

	@Override
	public int insert(BlankFillingQuestion record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(BlankFillingQuestion record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public BlankFillingQuestion selectByPrimaryKey(Integer blankFillingQuestionId) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",blankFillingQuestionId);
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingQuestion record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(BlankFillingQuestion record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}

	@Override
	public List<BlankFillingQuestion> selectAll() {
		return sqlSession.selectList(NAME_SPACE+"selectAll");
	}

}

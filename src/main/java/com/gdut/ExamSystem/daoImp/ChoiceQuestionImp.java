package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.dao.ChoiceQuestionMapper;

@Repository("ChoiceQuestionMapper")
public class ChoiceQuestionImp implements ChoiceQuestionMapper {
	private static final Logger logger = LoggerFactory.getLogger(ChoiceQuestionImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE="com.gdut.ExamSystem.dao.ChoiceQuestionMapper.";
	
	@Override
	public int deleteByPrimaryKey(Integer choiceQuestionId) {
		logger.debug("进入dao层");
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",choiceQuestionId);
	}
	
	@Override
	public int insert(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public ChoiceQuestion selectByPrimaryKey(Integer choiceQuestionId) {
		logger.debug("进入dao层");
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",choiceQuestionId);
	}
	@Override
	public int updateByPrimaryKeySelective(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}
	@Override
	public int updateByPrimaryKeyWithBLOBs(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}
	@Override
	public int updateByPrimaryKey(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public List<ChoiceQuestion> selectALL() {
		return sqlSession.selectList(NAME_SPACE+"selectAll");
	}


}

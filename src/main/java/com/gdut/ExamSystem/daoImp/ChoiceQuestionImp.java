package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.dao.ChoiceQuestionMapper;


public class ChoiceQuestionImp implements ChoiceQuestionMapper {
	private static final Logger logger = LoggerFactory.getLogger(ChoiceQuestionImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	@Override
	public int deleteByPrimaryKey(Integer choiceQuestionId) {
		logger.debug("进入dao层");
		return sqlSession.delete("com.gdut.ExamSystem.dao.ChoiceQuestionMapper.deleteByPrimaryKey",choiceQuestionId);
	}
	
	@Override
	public int insert(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.insert("com.gdut.ExamSystem.dao.ChoiceQuestionMapper.insert",record);
	}

	@Override
	public ChoiceQuestion selectByPrimaryKey(Integer choiceQuestionId) {
		logger.debug("进入dao层");
		return sqlSession.selectOne("com.gdut.ExamSystem.dao.ChoiceQuestionMapper.selectByPrimaryKey",choiceQuestionId);
	}
	@Override
	public int updateByPrimaryKeySelective(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.update("com.gdut.ExamSystem.dao.ChoiceQuestionMapper.updateByPrimaryKeySelective",record);
	}
	@Override
	public int updateByPrimaryKeyWithBLOBs(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.update("com.gdut.ExamSystem.dao.ChoiceQuestionMapper.updateByPrimaryKeyWithBLOBs",record);
	}
	@Override
	public int updateByPrimaryKey(ChoiceQuestion record) {
		logger.debug("进入dao层");
		return sqlSession.update("com.gdut.ExamSystem.dao.ChoiceQuestionMapper.updateByPrimaryKey",record);
	}

}

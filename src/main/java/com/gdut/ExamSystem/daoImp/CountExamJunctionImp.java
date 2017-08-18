package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.CountExamJunctionMapper;
import com.gdut.ExamSystem.model.CountExamJunctionKey;

@Repository("CountExamJunctionMapper")
public class CountExamJunctionImp implements CountExamJunctionMapper {
	private static final Logger logger = LoggerFactory.getLogger(ChoiceQuestionJunctionImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE="com.gdut.ExamSystem.dao.CountExamJunctionMapper.";
	
	
	@Override
	public int deleteByPrimaryKey(CountExamJunctionKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public int insert(CountExamJunctionKey record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(CountExamJunctionKey record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public List<String> findAllExamByTeacherCount(String counts) {
		return sqlSession.selectList(NAME_SPACE+"findAllExamByTeacherCounts",counts);
	}

	@Override
	public List<String> findAllTeacherCountsByExam(String examId) {
		return sqlSession.selectList(NAME_SPACE+"findAllTeacherCountsByExam",examId);
	}

}

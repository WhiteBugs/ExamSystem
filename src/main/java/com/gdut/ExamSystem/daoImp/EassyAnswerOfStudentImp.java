package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.EassyAnswerOfStudentMapper;
import com.gdut.ExamSystem.model.EassyAnswerOfStudent;
import com.gdut.ExamSystem.model.EassyAnswerOfStudentKey;
import com.gdut.ExamSystem.model.EassyQuestionJunctionKey;

@Repository("EassyAnswerOfStudentMapper")
public class EassyAnswerOfStudentImp implements EassyAnswerOfStudentMapper {
	private static final Logger logger = LoggerFactory.getLogger(EassyAnswerOfStudentImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.EassyAnswerOfStudentMapper.";
	
	@Override
	public int insert(EassyAnswerOfStudent record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(EassyAnswerOfStudent record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public int deleteByPrimaryKey(EassyAnswerOfStudentKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public EassyAnswerOfStudent selectByPrimaryKey(EassyAnswerOfStudentKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

	@Override
	public int updateByPrimaryKeySelective(EassyAnswerOfStudent record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(EassyAnswerOfStudent record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}

	@Override
	public int updateByPrimaryKey(EassyAnswerOfStudent record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public List<EassyAnswerOfStudent> selectStudentAllEassyAnswer(int examId, long studentId) {
		EassyAnswerOfStudentKey key = new EassyAnswerOfStudentKey();
		key.setExamId(examId);
		key.setStudentId(studentId);
		return sqlSession.selectList(NAME_SPACE+"selectStudentAllEassyAnswer",key);
	}
}

package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.ChoiceAnswerOfStudentMapper;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudent;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudentKey;

@Repository("ChoiceAnswerOfStudentMapper")
public class ChoiceAnswerOfStudentImp implements ChoiceAnswerOfStudentMapper {
	private static final Logger logger = LoggerFactory.getLogger(ChoiceAnswerOfStudentImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE="com.gdut.ExamSystem.dao.ChoiceAnswerOfStudentMapper.";

	@Override
	public int deleteByPrimaryKey(ChoiceAnswerOfStudentKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public int insert(ChoiceAnswerOfStudent record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(ChoiceAnswerOfStudent record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public ChoiceAnswerOfStudent selectByPrimaryKey(ChoiceAnswerOfStudentKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

	@Override
	public int updateByPrimaryKeySelective(ChoiceAnswerOfStudent record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(ChoiceAnswerOfStudent record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public List<ChoiceAnswerOfStudent> selectStudentAllChoiceAnswer(String examId, long studentId) {
		ChoiceAnswerOfStudentKey key = new ChoiceAnswerOfStudentKey();
		key.setTestPaperExamId(examId);
		key.setStudentId(studentId);
		return sqlSession.selectList(NAME_SPACE+"selectStudentAllChoiceAnswer",key);
	}

}

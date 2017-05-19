package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentJunctionMapper;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunction;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunctionKey;


@Repository("BlankFillingAnswerOfStudentJunctionMapper")
public class BlankFillingAnswerOfStudentJunctionMapperImp implements BlankFillingAnswerOfStudentJunctionMapper {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentJunctionMapper.";
	
	
	@Override
	public int deleteByPrimaryKey(BlankFillingAnswerOfStudentJunctionKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public int insert(BlankFillingAnswerOfStudentJunction record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(BlankFillingAnswerOfStudentJunction record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public BlankFillingAnswerOfStudentJunction selectByPrimaryKey(BlankFillingAnswerOfStudentJunctionKey key) {
		return sqlSession.selectOne(NAME_SPACE+"BlankFillingAnswerOfStudentJunction",key);
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingAnswerOfStudentJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(BlankFillingAnswerOfStudentJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public List<BlankFillingAnswerOfStudentJunction> selectStudentAllBlankFillingAnswerJunction(int examId,
			long studentId) {
		BlankFillingAnswerOfStudentJunctionKey key = new BlankFillingAnswerOfStudentJunctionKey();
		key.setExamId(examId);
		key.setStudentId(studentId);
		return sqlSession.selectList(NAME_SPACE+"selectStudentAllBlankFilling",key);
	}

}

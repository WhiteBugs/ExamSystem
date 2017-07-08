package com.gdut.ExamSystem.daoImp;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.gdut.ExamSystem.dao.ChoiceQuestionJunctionMapper;
import com.gdut.ExamSystem.model.ChoiceQuestionJunction;
import com.gdut.ExamSystem.model.ChoiceQuestionJunctionKey;


@Repository("ChoiceQuestionJunctionMapper")
public class ChoiceQuestionJunctionImp implements ChoiceQuestionJunctionMapper {
	private static final Logger logger = LoggerFactory.getLogger(ChoiceQuestionJunctionImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE="com.gdut.ExamSystem.dao.ChoiceQuestionJunctionMapper.";
	
	@Override
	public int deleteByPrimaryKey(ChoiceQuestionJunctionKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}

	@Override
	public int insert(ChoiceQuestionJunction record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(ChoiceQuestionJunction record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public ChoiceQuestionJunction selectByPrimaryKey(ChoiceQuestionJunctionKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}

	@Override
	public int updateByPrimaryKeySelective(ChoiceQuestionJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(ChoiceQuestionJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public List<Integer> findAllChoiceQuestionOfExam(int examID) {
		return sqlSession.selectList(NAME_SPACE+"findAllChoiceQuestion",examID);
	}

}

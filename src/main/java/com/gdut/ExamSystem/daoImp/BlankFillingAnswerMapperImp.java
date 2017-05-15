package com.gdut.ExamSystem.daoImp;

import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingAnswerMapper;
import com.gdut.ExamSystem.model.BlankFillingAnswer;

@Repository("BlankFillingAnswerMapper")
public class BlankFillingAnswerMapperImp implements BlankFillingAnswerMapper {

	@Override
	public int deleteByPrimaryKey(Integer blankFillingQuestionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BlankFillingAnswer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(BlankFillingAnswer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BlankFillingAnswer selectByPrimaryKey(Integer blankFillingQuestionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingAnswer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(BlankFillingAnswer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(BlankFillingAnswer record) {
		// TODO Auto-generated method stub
		return 0;
	}

}

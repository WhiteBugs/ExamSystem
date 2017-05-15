package com.gdut.ExamSystem.daoImp;

import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingQuestionMapper;
import com.gdut.ExamSystem.model.BlankFillingQuestion;

@Repository("BlankFillingQuestionMapper")
public class BlankFillingQuestionMapperImp implements BlankFillingQuestionMapper {

	@Override
	public int deleteByPrimaryKey(Integer blankFillingQuestionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BlankFillingQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(BlankFillingQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BlankFillingQuestion selectByPrimaryKey(Integer blankFillingQuestionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(BlankFillingQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

}

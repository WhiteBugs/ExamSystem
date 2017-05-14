package com.gdut.ExamSystem.daoImp;

import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentMapper;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudent;

@Repository("BlankFillingAnswerOfStudentMapper")
public class BlankFillingAnswerOfStudentMapperImp implements BlankFillingAnswerOfStudentMapper {

	@Override
	public int deleteByPrimaryKey(Integer blankFillingAnswerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BlankFillingAnswerOfStudent record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(BlankFillingAnswerOfStudent record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BlankFillingAnswerOfStudent selectByPrimaryKey(Integer blankFillingAnswerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingAnswerOfStudent record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(BlankFillingAnswerOfStudent record) {
		// TODO Auto-generated method stub
		return 0;
	}

}

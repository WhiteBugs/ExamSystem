package com.gdut.ExamSystem.daoImp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.BlankFillingJunctionMapper;
import com.gdut.ExamSystem.model.BlankFillingJunction;
import com.gdut.ExamSystem.model.BlankFillingJunctionKey;

@Repository("BlankFillingJunctionMapper")
public class BlankFillingJunctionMapperImp implements BlankFillingJunctionMapper {

	@Override
	public int deleteByPrimaryKey(BlankFillingJunctionKey key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BlankFillingJunction record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(BlankFillingJunction record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BlankFillingJunction selectByPrimaryKey(BlankFillingJunctionKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> findAllBlankFillingQuestionOfExam(int examID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(BlankFillingJunction record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(BlankFillingJunction record) {
		// TODO Auto-generated method stub
		return 0;
	}

}

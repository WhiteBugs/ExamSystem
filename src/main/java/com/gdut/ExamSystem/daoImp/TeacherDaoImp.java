package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.TeacherMapper;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;


public class TeacherDaoImp implements TeacherMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	
	@Override
	public int deleteByPrimaryKey(String count) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TeacherWithBLOBs selectByPrimaryKey(String count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TeacherWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(TeacherWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Teacher record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TeacherWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TeacherWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public java.util.List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

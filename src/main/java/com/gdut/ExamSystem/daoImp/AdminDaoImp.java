package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.AdminstratorMapper;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;


public class AdminDaoImp implements AdminstratorMapper {
	private static final Logger logger = LoggerFactory.getLogger(AdminDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	@Override
	public int deleteByPrimaryKey(String count) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(AdminstratorWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insertSelective(AdminstratorWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public AdminstratorWithBLOBs selectByPrimaryKey(String count) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateByPrimaryKeySelective(AdminstratorWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByPrimaryKeyWithBLOBs(AdminstratorWithBLOBs record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByPrimaryKey(Adminstrator record) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Teacher> findAllTeacher() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}

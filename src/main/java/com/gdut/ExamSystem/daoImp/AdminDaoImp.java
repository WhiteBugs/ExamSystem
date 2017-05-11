package com.gdut.ExamSystem.daoImp;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.AdminstratorMapper;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;


public class AdminDaoImp implements AdminstratorMapper {
	private static final Logger logger = LoggerFactory.getLogger(AdminDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.AdminstratorMapper.";
	
	
	@Override
	public int deleteByPrimaryKey(String count) {
		logger.debug("进入dao层");
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",count);
	}
	@Override
	public int insert(AdminstratorWithBLOBs record) {
		logger.debug("进入dao层");
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}
	@Override
	public int insertSelective(AdminstratorWithBLOBs record) {
		logger.debug("进入dao层");
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}
	@Override
	public AdminstratorWithBLOBs selectByPrimaryKey(String count) {
		logger.debug("进入dao层");
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",count);
	}
	@Override
	public int updateByPrimaryKeySelective(AdminstratorWithBLOBs record) {
		logger.debug("进入dao层");
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}
	@Override
	public int updateByPrimaryKeyWithBLOBs(AdminstratorWithBLOBs record) {
		logger.debug("进入dao层");
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}
	@Override
	public int updateByPrimaryKey(Adminstrator record) {
		logger.debug("进入dao层");
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}
	@Override
	public List<TeacherWithBLOBs> findAllTeacher() {
		logger.debug("进入dao层");
		return sqlSession.selectList("com.gdut.ExamSystem.dao.TeacherMapper.selectAllTeacher");
	}
	@Override
	public List<Student> findAllStudent() {
		logger.debug("进入dao层");
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectAllStudent");
	}

}

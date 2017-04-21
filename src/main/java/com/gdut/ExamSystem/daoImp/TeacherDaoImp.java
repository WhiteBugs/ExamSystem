package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.TeacherMapper;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;

import antlr.collections.List;

public class TeacherDaoImp implements TeacherMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(TeacherWithBLOBs teacher) {
		logger.debug("进入teacher_Dao层");
		logger.debug("还没补坑");
		return 0;
	}

	@Override
	public int insertSelective(TeacherWithBLOBs record) {
		logger.debug("进入teacher_Dao层");
		logger.debug("还没补坑");
		return 0;
	}

	@Override
	public int delete(Teacher teacher) {
		logger.debug("进入teacher_Dao层");
		logger.debug("删除考官");
		sqlSession.delete("com.gdut.ExamSystem.dao.TeacherMapper.delete",teacher);
		return 0;
	}

	@Override
	public Teacher selectOne(Teacher teacher) {
		logger.debug("进入teacher_Dao层");
		Teacher teac=sqlSession.selectOne("com.gdut.ExamSystem.dao.TeacherMapper.select",teacher);
		if(teac==null){
			logger.error("搜索返回空teacher");
		}
		return teac;
	}

	@Override
	public int update(Teacher teacher) {
		logger.debug("进入teacher_Dao层");
		logger.debug("更新考官信息");
		return sqlSession.update("com.gdut.ExamSystem.dao.TeacherMapper.update",teacher);
	}

	@Override
	public List selectAll() {
		logger.debug("进入teacher_Dao层");
		return (List) sqlSession.selectList("com.gdut.ExamSystem.dao.TeacherMapper.selectAll");
	}

}

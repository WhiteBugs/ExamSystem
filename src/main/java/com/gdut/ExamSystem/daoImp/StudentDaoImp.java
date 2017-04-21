package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;

import antlr.collections.List;

public class StudentDaoImp implements StudentMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public int insert(Student student) {
		logger.debug("进入学生Dao层");	
		return sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insert", student);
	}

	@Override
	public int insertSelective(Student student) {
		logger.debug("进入学生Dao层");
		return sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insertSelective",student);
	}

	@Override
	public int deleteOne(Student student) {
		logger.debug("进入学生Dao层");	
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.delect",student);
	}

	@Override
	public int deleteByStudentId(long ID) {
		logger.debug("进入学生Dao层");	
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByStudentId",ID);
	}

	@Override
	public int deleteByExamineeNumber(long examineenumber) {
		logger.debug("进入学生Dao层");	
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByExamineeNumber",examineenumber);
	}

	@Override
	public int deleteByName(String name) {
		logger.debug("进入学生Dao层");
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByName",name);
	}

	@Override
	public int deleteByMajor(String major) {
		logger.debug("进入学生Dao层");
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByMajor",major);
	}

	@Override
	public int deleteByClass(int classes) {
		logger.debug("进入学生Dao层");
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByClass",classes);
	}

	@Override
	public int deleteByGrade(int grade) {
		logger.debug("进入学生Dao层");
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByGrade",grade);
	}

	@Override
	public int update(Student student) {
		logger.debug("进入学生Dao层");	
		return sqlSession.update("com.gdut.ExamSystem.dao.StudentMapper.update",student);
	}

	@Override
	public int updateSelective(Student student) {
		logger.debug("进入学生Dao层");
		return sqlSession.update("com.gdut.ExamSystem.dao.StudentMapper.updateSelective",student);
	}


	@Override
	public List selectByClass(int classes) {
		logger.debug("进入学生Dao层");
		return (List) sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectByClass",classes);
	}

	@Override
	public List selectByName(String name) {
		logger.debug("进入学生Dao层");
		return (List) sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectByName",name);
	}

	@Override
	public Student selectByStudentId(long studentID) {
		logger.debug("进入学生Dao层");
		return sqlSession.selectOne("com.gdut.ExamSystem.dao.StudentMapper.selectByStudentId",studentID);
	}

	@Override
	public Student selectByExamineeNumber(long examineeNumber) {
		logger.debug("进入学生Dao层");
		return sqlSession.selectOne("com.gdut.ExamSystem.dao.StudentMapper.selectByExamineeNumber",examineeNumber);
	}

	@Override
	public List selectByGrade(int grade) {
		logger.debug("进入学生Dao层");
		return (List)sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectByGrade",grade);
	}

	@Override
	public List selectByMajor(String major) {
		logger.debug("进入学生Dao层");
		return (List)sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectByMajor",major);
	}

	@Override
	public List selectStudentScoreBelow(int score) {
		logger.debug("进入学生Dao层");
		return (List)sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectStudentScoreBelow",score);
	}

	@Override
	public List selectStudentScoreHiger(int score) {
		logger.debug("进入学生Dao层");
		return (List)sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectStudentScoreHiger",score);
	}

	@Override
	public List selectStudentScoreBetween(int higerScore, int lowScore) {
		logger.debug("进入学生Dao层");
		logger.debug("此坑未补");
		return null;
	}

	@Override
	public List selectAll() {
		logger.debug("进入学生Dao层");
		return (List) sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectAll");
	}	
}
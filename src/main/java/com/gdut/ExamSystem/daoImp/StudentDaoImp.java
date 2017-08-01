package com.gdut.ExamSystem.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;
@Repository("StudentMapper")
public class StudentDaoImp implements StudentMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(Student record) {
		return sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insert",record);
	}
	
	@Override
	public int insertSelective(Student record) {
		return sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insertSelective",record);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return sqlSession.update("com.gdut.ExamSystem.dao.StudentMapper.updateByPrimaryKeySelective",record);
	}
	
	@Override
	public int updateByPrimaryKey(Student record) {
		return sqlSession.update("com.gdut.ExamSystem.dao.StudentMapper.updateByPrimaryKey", record);
	}
	
	@Override
	public int deleteByPrimaryKey(Long studentId) {
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByPrimaryKey", studentId);
	}
	
	@Override
	public int deleteOne(Student student) {
		return deleteByPrimaryKey(student.getStudentId());
	}
	
	@Override
	public int deleteByID(long ID) {
		Student student = new Student();
		student.setId(ID);
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByOneProperty",student);
	}
	
	@Override
	public int deleteByExamineeNumber(long examineenumber) {
		Student student = new Student();
		student.setExamineeNumber(examineenumber);
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByOneProperty",student);
	}
	
	@Override
	public int deleteByName(String name) {
		Student student = new Student();
		student.setName(name);
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByOneProperty",student);
	}
	
	@Override
	public int deleteByMajor(String major) {
		Student student = new Student();
		student.setMajor(major);
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByOneProperty",student);
	}
	
	@Override
	public int deleteByClass(int classes) {
		Student student = new Student();
		student.setClasses(classes);
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByOneProperty",student);

	}
	
	@Override
	public int deleteByGrade(int grade) {
		Student student = new Student();
		student.setGrade(grade);
		return sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.deleteByOneProperty",student);

	}

	@Override
	public Student selectByPrimaryKey(Long studentId) {
		return sqlSession.selectOne("com.gdut.ExamSystem.dao.StudentMapper.selectByPrimaryKey",studentId);
	}
	
	@Override
	public java.util.List selectAll() {
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectAll");
	}
	
	@Override
	public java.util.List selectByClass(int classes) {
		Student student = new Student();
		student.setClasses(classes);
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectSelective",student);
	}
	
	@Override
	public java.util.List selectByName(String name) {
		Student student = new Student();
		student.setName(name);
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectSelective",student);
	}
	
	@Override
	public Student selectByStudentId(long studentID) {
		return selectByPrimaryKey(studentID);
	}
	
	@Override
	public Student selectByExamineeNumber(long examineeNumber) {
		Student student = new Student();
		student.setExamineeNumber(examineeNumber);
		return sqlSession.selectOne("com.gdut.ExamSystem.dao.StudentMapper.selectSelective",student);
	}
	
	@Override
	public java.util.List selectByGrade(int grade) {
		Student student = new Student();
		student.setGrade(grade);
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectSelective",student);
	}
	
	@Override
	public java.util.List selectByMajor(String major) {
		Student student = new Student();
		student.setMajor(major);
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectSelective",student);
	}

	@Override
	public List selectClassesByMajor(String major) {
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectClassesByMajor",major);
	}

	@Override
	public List selectAllMajor() {
		return sqlSession.selectList("com.gdut.ExamSystem.dao.StudentMapper.selectAllMajor");
	}
}
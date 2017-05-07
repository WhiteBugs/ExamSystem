package com.gdut.ExamSystem.service.serviceImpl;

import java.util.ArrayList;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gdut.ExamSystem.enums.Major;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.service.StudentService;



public class StudentServiceImp implements StudentService {
	
	@Resource(name="StudentMapper")
	private StudentMapper mapper;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);

	@Override
	public void add(Student student) {
		logger.debug("进入service层");
		mapper.insert(student);
		
	}

	@Override
	public void delete(Student student) {
		logger.debug("进入service层");
		mapper.deleteOne(student);
		
	}

	@Override
	public void deleteByGrade(int grade) {
		logger.debug("进入service层");
		mapper.deleteByGrade(grade);
	}

	@Override
	public void deleteByStudentID(long studentID) {
		logger.debug("进入service层");
		mapper.deleteByPrimaryKey(studentID);
	}

	@Override
	public void deleteByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层");
		mapper.deleteByExamineeNumber(examineeNumber);
	}

	@Override
	public void delettByClass(int classes) {
		logger.debug("进入service层");
		mapper.deleteByClass(classes);
	}

	@Override
	public Student findStudentByStudentID(long studentID) {
		logger.debug("进入service层");
		return mapper.selectByStudentId(studentID);
	}

	@Override
	public Student findStudentByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层");
		return mapper.selectByExamineeNumber(examineeNumber);
	}

	@Override
	public ArrayList<Student> findStudentByName(String name) {
		logger.debug("进入service层");
		return (ArrayList<Student>)mapper.selectByName(name);
	}

	@Override
	public ArrayList<Student> findStudentByClasses(int classes) {
		logger.debug("进入service层");
		return (ArrayList<Student>)mapper.selectByClass(classes);
	}

	@Override
	public ArrayList<Student> findStudentByMajor(Major major) {
		logger.debug("进入service层");
		return (ArrayList<Student>)mapper.selectByMajor(major.toString());
	}

	@Override
	public ArrayList<Student> findStudentScoreBelow(int score) {
		logger.debug("进入service层");
		return (ArrayList<Student>)mapper.selectStudentScoreBelow(score);
	}

	@Override
	public ArrayList<Student> findStudentScoreHigerThanScore(int score) {
		logger.debug("进入service层");
		return (ArrayList<Student>)mapper.selectStudentScoreHiger(score);
	}

	@Override
	public ArrayList<Student> findStudentScoreBetweenScore(int higherScore, int lowScore) {
		logger.debug("进入service层");
		return (ArrayList<Student>)mapper.selectStudentScoreBetween(higherScore, lowScore);
	}

	@Override
	public void changeStudentExamineeNumber(long ExamineeNumber, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setExamineeNumber(ExamineeNumber);
		mapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentName(String name, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setName(name);
		mapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentSex(String sex, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setSex(sex);
		mapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentGrade(int grade, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setGrade(grade);
		mapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentClasses(int classes, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setClasses(classes);
		mapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentMajor(String major, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setMajor(major);
		mapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentPassword(String password, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setPassword(password);
		mapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentScore(int score, Student student) {
		logger.debug("进入service层");
		Student student2 = mapper.selectByPrimaryKey(student.getStudentId());
		student2.setScore(score);
		mapper.updateByPrimaryKeySelective(student2);
	}
}

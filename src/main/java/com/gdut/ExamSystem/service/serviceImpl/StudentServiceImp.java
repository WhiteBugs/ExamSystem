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
		logger.debug("进入service层学生");
		mapper.insert(student);
	}

	@Override
	public void delete(Student student) {
		logger.debug("进入service层学生");
		mapper.deleteOne(student);
	}

	@Override
	public void deleteByStudentID(long studentID) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void deleteByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public Student findStudentByStudentID(long studentID) {
		logger.debug("进入service层学生");
		return mapper.selectByStudentId(studentID);
	}

	@Override
	public Student findStudentByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层学生");
		return mapper.selectByExamineeNumber(examineeNumber);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> findStudentByName(String name) {
		logger.debug("进入service层学生");
		return (ArrayList<Student>) mapper.selectByName(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> findStudentByClasses(int classes) {
		logger.debug("进入service层学生");
		return (ArrayList<Student>) mapper.selectByClass(classes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> findStudentByMajor(Major major) {
		logger.debug("进入service层学生");
		return (ArrayList<Student>) mapper.selectByMajor(major.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> findStudentScoreBelow(int score) {
		logger.debug("进入service层学生");
		return (ArrayList<Student>) mapper.selectStudentScoreBelow(score);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> findStudentScoreHigerThanScore(int score) {
		logger.debug("进入service层学生");
		return (ArrayList<Student>) mapper.selectStudentScoreHiger(score);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> findStudentScoreBetweenScore(int higerScore, int lowScore) {
		logger.debug("进入service层学生");
		return (ArrayList<Student>) mapper.selectStudentScoreBetween(higerScore, lowScore);
	}

	@Override
	public void changeStudentExamineeNumber(long examineeNumber,Student student) {
		logger.debug("进入service层学生");
		student.setExamineenumber(examineeNumber);
		mapper.updateSelective(student);
	}

	@Override
	public void changeStudentName(String name,Student student) {
		logger.debug("进入service层学生");
		student.setName(name);
		mapper.updateSelective(student);
	}

	@Override
	public void changeStudentSex(String sex,Student student) {
		logger.debug("进入service层学生");
		student.setSex(sex);
		mapper.updateSelective(student);
	}

	@Override
	public void changeStudentGrade(int grade,Student student) {
		logger.debug("进入service层学生");
		student.setGrade(grade);
		mapper.updateSelective(student);
	}

	@Override
	public void changeStudentClasses(int classes,Student student) {
		logger.debug("进入service层学生");
		student.setClasses(classes);
		mapper.updateSelective(student);
	}

	@Override
	public void changeStudentMajor(String major,Student student) {
		logger.debug("进入service层学生");
		student.setMajor(major);
		mapper.updateSelective(student);
	}

	@Override
	public void changeStudentPassword(String password,Student student) {
		logger.debug("进入service层学生");
		student.setPassword(password);
		mapper.updateSelective(student);
	}

	@Override
	public void changeStudentScore(int score,Student student) {
		logger.debug("进入service层学生");
		student.setScore(score);
		mapper.updateSelective(student);
	}

	@Override
	public void deleteByGrade(int grade) {
		logger.debug("进入service层学生");
	    mapper.deleteByGrade(grade);
		
	}

	@Override
	public void delettByClass(int classes) {
		logger.debug("进入service层学生");
		mapper.deleteByClass(classes);
	}

}

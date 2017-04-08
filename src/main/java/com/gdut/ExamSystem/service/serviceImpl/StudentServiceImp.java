package com.gdut.ExamSystem.service.serviceImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.ExamSystem.enums.Major;
import com.gdut.ExamSystem.enums.Sex;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.service.StudentService;


@Service  
@Transactional
public class StudentServiceImp implements StudentService {
	@Resource(name="StudentMapper")
	private StudentMapper mapper;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);
	
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int search(String studentId, String userPassword) {
		// TODO Auto-generated method stub
		logger.info("传入学号"+studentId);
		Student student =mapper.getStudent(studentId);
		if(student==null){
			logger.error("数据库查询不到学生对象");
			return -1;
		}
		long studentPassword = mapper.getStudent(studentId).getPassword();
		logger.debug("数据库的学生密码是"+studentPassword);
		logger.debug("浏览器传入的学生密码是"+userPassword);
		if(!(userPassword.equals(studentPassword))){
			logger.debug("与查询密码不符合");
			return -2;
		}
		logger.debug("验证学生账号密码正确");
		return 0;
	}

	@Override
	public void deleteByID(String ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByExamineeNumber(String ExamineeNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findStudentByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByExamineeNumber(long ExamineeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> findStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<Student> findStudentByClasses(int classes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> findStudentByMajor(Major major) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> findStudentScoreBelow(int score) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> findStudentScoreHigerThanScore(int score) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> findStudentScoreBetweenScore(int higerScore, int lowScore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeStudentID(String ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentExamineeNumber(long ExamineeNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentSex(Sex sex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentGrade(int grade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentClasses(int classes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentMajor(Major major) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStudentScore(int score) {
		// TODO Auto-generated method stub
		
	}


}

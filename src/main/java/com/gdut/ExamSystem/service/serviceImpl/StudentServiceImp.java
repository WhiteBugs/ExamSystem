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
		logger.debug("进入service层学生");
		mapper.insert(student);
	}

	@Override
	public void delete(Student student) {
		logger.debug("进入service层学生");
		mapper.deleteOne(student);
	}

	@Override
	public void deleteByID(String ID) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void deleteByExamineeNumber(String ExamineeNumber) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public Student findStudentByID(String ID) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public Student findStudentByExamineeNumber(long ExamineeNumber) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public ArrayList<Student> findStudentByName(String name) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public ArrayList<Student> findStudentByClasses(int classes) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public ArrayList<Student> findStudentByMajor(Major major) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public ArrayList<Student> findStudentScoreBelow(int score) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public ArrayList<Student> findStudentScoreHigerThanScore(int score) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public ArrayList<Student> findStudentScoreBetweenScore(int higerScore, int lowScore) {
		logger.debug("进入service层学生");
		return null;
	}

	@Override
	public void changeStudentID(String ID) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentExamineeNumber(long ExamineeNumber) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentName(String name) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentSex(Sex sex) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentGrade(int grade) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentClasses(int classes) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentMajor(Major major) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentPassword(String password) {
		logger.debug("进入service层学生");
		
	}

	@Override
	public void changeStudentScore(int score) {
		logger.debug("进入service层学生");
		
	}

}

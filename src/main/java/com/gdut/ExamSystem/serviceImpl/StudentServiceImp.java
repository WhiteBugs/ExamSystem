package com.gdut.ExamSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gdut.ExamSystem.enums.Major;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.service.StudentService;


@Service("StudentService")
public class StudentServiceImp implements StudentService {
	
	@Resource(name="StudentMapper")
	private StudentMapper studentMapper;
	
	@Resource(name="StudentExamJunctionMapper")
	private StudentExamJunctionMapper studentExamJunctionMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);

	@Override
	public void add(Student student) {
		logger.debug("进入service层");
		studentMapper.insert(student);
	}

	@Override
	public void delete(Student student) {
		logger.debug("进入service层");
		studentMapper.deleteOne(student);	
	}

	@Override
	public void deleteByGrade(int grade) {
		logger.debug("进入service层");
		studentMapper.deleteByGrade(grade);
	}

	@Override
	public void deleteByStudentID(long studentID) {
		logger.debug("进入service层");
		studentMapper.deleteByPrimaryKey(studentID);
	}

	@Override
	public void deleteByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层");
		studentMapper.deleteByExamineeNumber(examineeNumber);
	}

	@Override
	public void delettByClass(int classes) {
		logger.debug("进入service层");
		studentMapper.deleteByClass(classes);
	}

	@Override
	public Student findStudentByStudentID(long studentID) {
		logger.debug("进入service层");
		return studentMapper.selectByStudentId(studentID);
	}

	@Override
	public Student findStudentByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层");
		return studentMapper.selectByExamineeNumber(examineeNumber);
	}

	@Override
	public ArrayList<Student> findStudentByName(String name) {
		logger.debug("进入service层");
		return (ArrayList<Student>)studentMapper.selectByName(name);
	}

	@Override
	public ArrayList<Student> findStudentByClasses(int classes) {
		logger.debug("进入service层");
		return (ArrayList<Student>)studentMapper.selectByClass(classes);
	}

	@Override
	public ArrayList<Student> findStudentByMajor(Major major) {
		logger.debug("进入service层");
		return (ArrayList<Student>)studentMapper.selectByMajor(major.toString());
	}

	@Override
	public void changeStudentExamineeNumber(long ExamineeNumber, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setExamineeNumber(ExamineeNumber);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentName(String name, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setName(name);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentSex(String sex, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setSex(sex);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentGrade(int grade, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setGrade(grade);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentClasses(int classes, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setClasses(classes);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentMajor(String major, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setMajor(major);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentPassword(String password, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setPassword(password);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public boolean isStudentExist(long studentID) {
		if(findStudentByStudentID(studentID)!=null){
			return true;
		}else
		return false;
	}

	@Override
	public List<Integer> findStudentExamID(long studentID) {
		List<Integer> examIdList = new ArrayList<>();
		for(StudentExamJunction examJunction : studentExamJunctionMapper.findStudentAllExamJunction(studentID)){
			examIdList.add(examJunction.getExamId());
		}
		return examIdList;
	}

	@Override
	public List<Student> findAllStudent() {
		return studentMapper.selectAll();
	}
}

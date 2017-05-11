package com.gdut.ExamSystem.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.ExamSystem.dao.AdminstratorMapper;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.model.TestPaperKey;
import com.gdut.ExamSystem.service.AdminService;


@Service  
@Transactional
public class AdminServiceImp implements AdminService {
	
	@Resource(name="AdminMapper")
	private AdminstratorMapper adminMapper;
	
	@Resource(name="StudentMapper")
	private StudentMapper studentMapper;
    
	@Resource(name="TestPaperMapper")
	private TestPaperMapper testPaperMapper;
	
	@Resource(name="StudentExamJunction")
	private StudentExamJunctionMapper studentExamJunctionMapper;
	
	@Override
	public AdminstratorWithBLOBs findAdminByCount(String count) {
		return adminMapper.selectByPrimaryKey(count);
	}

	@Override
	public void setSafeQuestionAndAnswer(String count, String question, String answer) {
		AdminstratorWithBLOBs adminBlobs = adminMapper.selectByPrimaryKey(count);
		adminBlobs.setSafeQuestion(question);
		adminBlobs.setSafeAnswer(answer);
		adminMapper.updateByPrimaryKeyWithBLOBs(adminBlobs);
	}

	@Override
	public void changeAdminPassword(String count, String password) {
		Adminstrator admin = (Adminstrator)findAdminByCount(count);
		admin.setPassword(password);
		adminMapper.updateByPrimaryKey(admin);
	}

	@Override
	public void changeSafeQuestion(String count, String question) {
		AdminstratorWithBLOBs admin = findAdminByCount(count);
		admin.setSafeQuestion(question);
		adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public void changeSafeAnswer(String count, String answer) {
		AdminstratorWithBLOBs admin = findAdminByCount(count);
		admin.setSafeAnswer(answer);
		adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public void addStudent(TestPaper testPaper, Student student) {
		studentMapper.insert(student);
		StudentExamJunctionKey studentExamJunction = new StudentExamJunctionKey();
		studentExamJunction.setExamId(testPaper.getExamId());
		studentExamJunction.setStudentId(student.getStudentId());
		studentExamJunctionMapper.insert(studentExamJunction);
	}

	@Override
	public void updateStudent(TestPaper testPaper, Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public void deleteStudent(TestPaper testPaper, Student student) {
		studentMapper.deleteOne(student);
		StudentExamJunctionKey studentExamJunctionkey = new StudentExamJunctionKey();
		studentExamJunctionkey.setExamId(testPaper.getExamId());
		studentExamJunctionkey.setStudentId(student.getStudentId());
		studentExamJunctionMapper.deleteByPrimaryKey(studentExamJunctionkey);
	}

	@Override
	public void addTeacher(TestPaper testPaper, Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTeacher(TestPaper testPaper, Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeacher(TestPaper testPaper, Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addExam(TestPaper testPaper, Teacher teacher, List<Student> studentList) {
		testPaper.setCount(teacher.getCount());
		testPaperMapper.insert(testPaper);
		for (Student student : studentList) {
			addStudent(testPaper, student);
		}
	}
	
}

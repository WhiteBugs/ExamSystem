package com.gdut.ExamSystem.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gdut.ExamSystem.dao.AdminstratorMapper;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.dao.TeacherMapper;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.model.TestPaperKey;
import com.gdut.ExamSystem.service.AdminService;


@Service("AdminService")
public class AdminServiceImp implements AdminService {
	
	@Resource(name="AdminstratorMapper")
	private AdminstratorMapper adminMapper;
	
	@Resource(name="StudentMapper")
	private StudentMapper studentMapper;
    
	@Resource(name="TeacherMapper")
	private TeacherMapper teacherMapper;
	@Resource(name="TestPaperMapper")
	private TestPaperMapper testPaperMapper;
	
	@Resource(name="StudentExamJunctionMapper")
	private StudentExamJunctionMapper studentExamJunctionMapper;

	
	@Override
	public AdminstratorWithBLOBs findAdminByCount(String count) {
		
		return adminMapper.selectByPrimaryKey(count);
	}

	@Override
	public void setSafeQuestionAndAnswer(String count, String question, String answer) {
		AdminstratorWithBLOBs admin = adminMapper.selectByPrimaryKey(count);
		admin.setSafeQuestion(question);
		admin.setSafeAnswer(answer);
		adminMapper.updateByPrimaryKeyWithBLOBs(admin);
	}

	@Override
	public void changeAdminPassword(String count, String password) {
		AdminstratorWithBLOBs admin = adminMapper.selectByPrimaryKey(count);
		admin.setPassword(password);
		adminMapper.updateByPrimaryKeyWithBLOBs(admin);
	}

	@Override
	public void changeSafeQuestion(String count, String question) {
		AdminstratorWithBLOBs admin = adminMapper.selectByPrimaryKey(count);
		admin.setSafeQuestion(question);
		adminMapper.updateByPrimaryKeyWithBLOBs(admin);
	}

	@Override
	public void changeSafeAnswer(String count, String answer) {
		AdminstratorWithBLOBs admin = adminMapper.selectByPrimaryKey(count);
		admin.setSafeAnswer(answer);
		adminMapper.updateByPrimaryKeyWithBLOBs(admin);
	}

	@Override
	public void addStudent(TestPaperKey testPaperKey, Student student) {
		StudentExamJunctionKey record = new StudentExamJunctionKey();
		record.setExamId(testPaperKey.getExamId());
		record.setStudentId(student.getStudentId());
		studentExamJunctionMapper.insert(record);
	}

	@Override
	public void updateStudent(Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public void deleteStudent(TestPaperKey testPaperKey, Student student) {
		StudentExamJunctionKey record = new StudentExamJunctionKey();
		record.setExamId(testPaperKey.getExamId());
		record.setStudentId(student.getStudentId());
		studentExamJunctionMapper.deleteByPrimaryKey(record);
	}

	@Override
	public void addTeacher(TestPaperKey testPaperKey, Teacher teacher) {
		TestPaper testPaper = testPaperMapper.selectByPrimaryKey(testPaperKey);
		testPaper.setCount(teacher.getCount());
		testPaperMapper.updateByPrimaryKey(testPaper);
	}

	@Override
	public void updateTeacher( TeacherWithBLOBs teacher) {
		teacherMapper.updateByPrimaryKeyWithBLOBs(teacher);
	}

	@Override
	public void deleteTeacher( Teacher teacher) {
	    teacherMapper.deleteByPrimaryKey(teacher.getCount());
	}

	@Override
	public void addExam(TestPaper testPaper, Teacher teacher, List<Long> studentIDList) {
		testPaperMapper.insertSelective(testPaper);
		StudentExamJunctionKey record = new StudentExamJunctionKey();
		record.setExamId(testPaper.getExamId());
		for (Long studentID : studentIDList) {
			record.setStudentId(studentID);
			studentExamJunctionMapper.insert(record);
		}
	}

	@Override
	public boolean isExist(String count) {
		if(findAdminByCount(count)!=null)
			return true;
		return false;
	}

	
}

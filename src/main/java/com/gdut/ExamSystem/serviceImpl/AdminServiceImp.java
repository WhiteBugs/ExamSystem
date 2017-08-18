package com.gdut.ExamSystem.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gdut.ExamSystem.dao.AdminstratorMapper;
import com.gdut.ExamSystem.dao.CountExamJunctionMapper;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.dao.TeacherMapper;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;
import com.gdut.ExamSystem.model.CountExamJunctionKey;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;
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
	
	@Resource(name="CountExamJunctionMapper")
	private CountExamJunctionMapper countExamJunctionMapper;

	
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
	public void addStudent(String examId, Student student) {
		StudentExamJunction record = new StudentExamJunction();
		record.setExamId(examId);;
		record.setStudentId(student.getStudentId());
		record.setScore(0);
		studentExamJunctionMapper.insert(record);
	}

	@Override
	public void updateStudent(Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public void deleteStudent(String examId,  Student student) {
		StudentExamJunctionKey record = new StudentExamJunctionKey();
		record.setExamId(examId);
		record.setStudentId(student.getStudentId());
		studentExamJunctionMapper.deleteByPrimaryKey(record);
	}

	@Override
	public void addTeacher(String examId, List<String> teachers) {
		TestPaper testPaper = testPaperMapper.selectByPrimaryKey(examId);
		for(String teacher : teachers){
			CountExamJunctionKey key = new CountExamJunctionKey();
			key.setTeacherCount(teacher);
			key.setTestPaperExamId(examId);
			countExamJunctionMapper.insert(key);
		}
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
		StudentExamJunction record = new StudentExamJunction();
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

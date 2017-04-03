package com.gdut.ExamSystem.service.serviceImpl;

import javax.annotation.Resource;

import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.service.StudentService;

public class StudentServiceImp implements StudentService {
	@Resource(name="StudentMapper")
	private StudentMapper mapper;
	

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeStudentByName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int search(String studentId, String userPassword) {
		// TODO Auto-generated method stub
		long studentID = Long.parseUnsignedLong(studentId);
		Student student =mapper.getStudent(studentID);
		if(student==null){
			return -1;
		}
		String studentPassword = mapper.getStudent(studentID).getPassword();
		if(userPassword!=studentPassword){
			return -2;
		}
		return 0;
	}

}

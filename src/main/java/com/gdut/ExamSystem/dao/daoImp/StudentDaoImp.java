package com.gdut.ExamSystem.dao.daoImp;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;

public class StudentDaoImp implements StudentMapper {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public int insert(Student record) {
		sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insert", record);
		return 0;
	}

	@Override
	public int insertSelective(Student record) {
		
		return 0;
	}

	@Override
	public Student getStudent(long StudentId) {
		// TODO Auto-generated method stub
		
		return (Student)sqlSession.selectOne("com.gdut.ExamSystem.dao.StudentMapper.select",StudentId);
	}

	
}

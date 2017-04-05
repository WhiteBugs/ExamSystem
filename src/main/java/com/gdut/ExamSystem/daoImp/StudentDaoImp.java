package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.model.Student;

public class StudentDaoImp implements StudentMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public int insert(Student record) {
		sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insert", record);
		return 0;
	}

	@Override
	public int insertSelective(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student getStudent(String studentId) {
		// TODO Auto-generated method stub
        logger.debug("dao层根据学号查询学生");
        Student student=(Student)sqlSession.selectOne("com.gdut.ExamSystem.dao.StudentMapper.select",studentId);
		if(student==null){
			logger.error("查询不到此学生");
		}else{
			logger.debug("查询学生成功");
		}
        return student; 
	}

	
}

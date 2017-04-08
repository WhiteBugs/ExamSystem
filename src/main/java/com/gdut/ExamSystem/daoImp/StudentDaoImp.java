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
	public int insert(Student student) {
		logger.debug("进入学生Dao层");
		sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insert", student);
		return 0;
	}

	@Override
	public int insertSelective(Student student) {
		logger.debug("进入学生Dao层");
		int i = sqlSession.insert("com.gdut.ExamSystem.dao.StudentMapper.insertSelective",student);
		return i;
	}

	@Override
	public int deleteOne(Student student) {
		logger.debug("进入学生Dao层");
		sqlSession.delete("com.gdut.ExamSystem.dao.StudentMapper.delete",student);
		return 0;
	}

	@Override
	public Student selectOne(Student student) {
		logger.debug("进入学生Dao层");
		Student stu=sqlSession.selectOne("com.gdut.ExamSystem.dao.StudentMapper.select",student);
		if(stu==null){
			logger.error("搜索返回空学生");
		}
		return stu;
	}

	@Override
	public int update(Student student) {
		logger.debug("进入学生Dao层");
		sqlSession.update("com.gdut.ExamSystem.dao.StudentMapper.update",student);
		return 0;
	}	
}
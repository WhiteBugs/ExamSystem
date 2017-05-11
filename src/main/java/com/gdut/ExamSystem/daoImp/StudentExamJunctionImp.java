package com.gdut.ExamSystem.daoImp;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;

public class StudentExamJunctionImp implements StudentExamJunctionMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentExamJunctionImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.StudentExamJunctionMapper.";
	
	
	@Override
	public int deleteByPrimaryKey(StudentExamJunctionKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}
	@Override
	public int insert(StudentExamJunctionKey record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}
	@Override
	public int insertSelective(StudentExamJunctionKey record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}
	@Override
	public int deleteByExamID(int ExamID) {
		return sqlSession.delete(NAME_SPACE+"deleteByExamID",ExamID);
	}
	@Override
	public List<Long> findAllStudentIDByExamID(int examID) {
		return sqlSession.selectList(NAME_SPACE+"findAllStudentIDByExamID",examID);
	}
	@Override
	public Long findOneStudentIDInExam(StudentExamJunctionKey key) {
		return sqlSession.selectOne(NAME_SPACE+"findOneStudentIDInExam",key);
	}
}

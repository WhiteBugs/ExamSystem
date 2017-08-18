package com.gdut.ExamSystem.daoImp;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;
@Repository("StudentExamJunctionMapper")
public class StudentExamJunctionImp implements StudentExamJunctionMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentExamJunctionImp.class);
	
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.StudentExamJunctionMapper.";
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	

	@Override
	public int deleteByPrimaryKey(StudentExamJunctionKey key) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",key);
	}
	
	
	@Override
	public StudentExamJunction selectByPrimaryKey(StudentExamJunctionKey key) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",key);
	}
	
	@Override
	public int updateByPrimaryKeySelective(StudentExamJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}
	
	@Override
	public int updateByPrimaryKey(StudentExamJunction record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}
	
	@Override
	public List<Long> findStudentScoreBelow(String examId, int score) {
		Map map = new HashMap<>();
		map.put("examId", examId);
		map.put("score", score);
		return sqlSession.selectList(NAME_SPACE+"findStudentScoreBelow",map);
	}
	
	@Override
	public List<Long> findStudentScoreHiger(String examId, int score) {
		Map map = new HashMap<>();
		map.put("examId", examId);
		map.put("score", score);
		return sqlSession.selectList(NAME_SPACE+"findStudentScoreHiger",map);
	}
	
	@Override
	public List<Long> findStudentScoreBetween(String examId, int highScore, int lowScore) {
		Map map = new HashMap<>();
		map.put("examId", examId);
		map.put("highScore", highScore);
		map.put("lowScore", lowScore);
		return sqlSession.selectList(NAME_SPACE+"findStudentScoreBetween",map);
	}
	
	@Override
	public int deleteByExamID(String examID) {
		return sqlSession.delete(NAME_SPACE+"deleteByExamID",examID);
	}
	
	@Override
	public List<Long> findAllStudentIDByExamID(String examID) {
		return sqlSession.selectList(NAME_SPACE+"findAllStudentIDByExamID",examID);
	}
	
	@Override
	public Long findOneStudentIDInExam(StudentExamJunctionKey key) {
		return sqlSession.selectOne(NAME_SPACE+"findOneStudentIDInExam",key);
	}
	
	@Override
	public List<StudentExamJunction> findStudentAllExamJunction(long studentID) {
		return sqlSession.selectList(NAME_SPACE+"findStudentAllExam",studentID);
	}


	@Override
	public int insert(StudentExamJunction record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}


	@Override
	public int insertSelective(StudentExamJunction record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}
	
}

package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gdut.ExamSystem.dao.TeacherMapper;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;

@Repository("TeacherMapper")
public class TeacherDaoImp implements TeacherMapper {
	private static final Logger logger = LoggerFactory.getLogger(TeacherDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.TeacherMapper.";
	
	
	
	@Override
	public int deleteByPrimaryKey(String count) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",count);
	}

	@Override
	public TeacherWithBLOBs selectByPrimaryKey(String count) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",count);
	}

	@Override
	public int updateByPrimaryKeySelective(TeacherWithBLOBs record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(TeacherWithBLOBs record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}

	@Override
	public int updateByPrimaryKey(Teacher record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public int insert(TeacherWithBLOBs record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(TeacherWithBLOBs record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public java.util.List<Teacher> selectAllTeacher() {
		return sqlSession.selectList(NAME_SPACE+"selectAllTeacher");
	}

}

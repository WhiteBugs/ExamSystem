package com.gdut.ExamSystem.daoImp;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdut.ExamSystem.dao.AdminstratorMapper;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.AdminstratorWithBLOBs;

public class AdminDaoImp implements AdminstratorMapper {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public int insert(AdminstratorWithBLOBs record) {
		logger.debug("进入管理员Dao层");
		logger.debug("还没补坑");
		return 0;
	}

	@Override
	public int insertSelective(AdminstratorWithBLOBs record) {
		logger.debug("进入管理员Dao层");
		logger.debug("还没补坑");
		return 0;
	}

	@Override
	public int insert(Adminstrator admin) {
		logger.debug("进入管理员Dao层");
		sqlSession.insert("com.gdut.ExamSystem.dao.AdminstratorMapper.insert",admin);
		return 0;
	}

	@Override
	public int insertSelective(Adminstrator admin) {
		logger.debug("进入管理员Dao层");
		sqlSession.insert("com.gdut.ExamSystem.dao.AdminstratorMapper.insertSelective",admin);
		return 0;
	}

	@Override
	public int delete(Adminstrator admin) {
		logger.debug("进入管理员Dao层");
		sqlSession.delete("com.gdut.ExamSystem.dao.AdminstratorMapper.delete",admin);
		return 0;
	}

	@Override
	public Adminstrator selectOne(Adminstrator admin) {
		logger.debug("进入管理员Dao层");
		Adminstrator adminstrator=sqlSession.selectOne("com.gdut.ExamSystem.dao.AdminstratorMapper.select",admin);
		if(adminstrator==null){
			logger.error("搜索返回空admin");
		}
		return adminstrator;
	}

	@Override
	public int update(Adminstrator admin) {
		logger.debug("进入管理员Dao层");
		sqlSession.update("com.gdut.ExamSystem.dao.AdminstratorMapper.update",admin);
		return 0;
	}

}

package com.gdut.ExamSystem.daoImp;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.TestPaper;


@Repository("TestPaperMapper")
public class TestPaperImp implements TestPaperMapper {
	private static final Logger logger = LoggerFactory.getLogger(TestPaperImp.class);
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.gdut.ExamSystem.dao.TestPaperMapper.";
	
	@Override
	public int deleteByPrimaryKey(Integer examId) {
		return sqlSession.delete(NAME_SPACE+"deleteByPrimaryKey",examId);
	}

	@Override
	public int insert(TestPaper record) {
		return sqlSession.insert(NAME_SPACE+"insert",record);
	}

	@Override
	public int insertSelective(TestPaper record) {
		return sqlSession.insert(NAME_SPACE+"insertSelective",record);
	}

	@Override
	public TestPaper selectByPrimaryKey(Integer examId) {
		return sqlSession.selectOne(NAME_SPACE+"selectByPrimaryKey",examId);
	}

	@Override
	public int updateByPrimaryKeySelective(TestPaper record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(TestPaper record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKey",record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(TestPaper record) {
		return sqlSession.update(NAME_SPACE+"updateByPrimaryKeyWithBLOBs",record);
	}

	@Override
	public List<TestPaper> findAllExam() {
		return sqlSession.selectList(NAME_SPACE+"findAllExam");
	}

	@Override
	public List<TestPaper> findAllExamByTeacherCount(String count) {
		return sqlSession.selectList(NAME_SPACE+"selectByCount",count);
	}

}

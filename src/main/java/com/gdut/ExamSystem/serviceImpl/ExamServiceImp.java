package com.gdut.ExamSystem.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gdut.ExamSystem.dao.BlankFillingAnswerMapper;
import com.gdut.ExamSystem.dao.BlankFillingJunctionMapper;
import com.gdut.ExamSystem.dao.BlankFillingQuestionMapper;
import com.gdut.ExamSystem.dao.ChoiceQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.ChoiceQuestionMapper;
import com.gdut.ExamSystem.dao.EassyQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.EassyQuestionMapper;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.BlankFillingAnswer;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.ExamService;

@Service("ExamService")
public class ExamServiceImp implements ExamService {
	@Resource(name="TestPaperMapper")
	private TestPaperMapper testPaperMapper;
	
	@Resource(name="ChoiceQuestionJunctionMapper")
	private ChoiceQuestionJunctionMapper choiceQuestionJunctionMapper;

	@Resource(name="BlankFillingJunctionMapper")
	private BlankFillingJunctionMapper blankFillingJunctionMapper;
	
	@Resource(name="EassyQuestionJunctionMapper")
	private EassyQuestionJunctionMapper eassyQuestionJunctionMapper;
	
	@Resource(name="ChoiceQuestionMapper")
	private ChoiceQuestionMapper choiceQuestionMapper;
	
	@Resource(name="BlankFillingQuestionMapper")
	private BlankFillingQuestionMapper blankFillingQuestionMapper;
	
	@Resource(name="BlankFillingAnswerMapper")
	private BlankFillingAnswerMapper blankFillingAnswerMapper;
	
	@Resource(name="EassyQuestionMapper")
	private EassyQuestionMapper eassyQuestionMapper;
	
	@Resource(name="StudentExamJunctionMapper")
	private StudentExamJunctionMapper studentExamJunctionMapper;
	
	@Override
	public List<Integer> findChoiceQuestionOfExam(int examID) {
		return choiceQuestionJunctionMapper.findAllChoiceQuestionOfExam(examID);
	}

	@Override
	public List<Integer> findBlankFillingQuestionOfExam(int examID) {
		return blankFillingJunctionMapper.findAllBlankFillingQuestionOfExam(examID);
	}

	@Override
	public List<Integer> findEassyQuestionOfExam(int examID) {
		return eassyQuestionJunctionMapper.findAllEassyQuestionOfExam(examID);
	}

	@Override
	public int addExam(TestPaper testPaper) {
		return testPaperMapper.insert(testPaper);
	}

	@Override
	public List<ChoiceQuestion> findAllChoiceQuestion() {
		return choiceQuestionMapper.selectALL();
	}

	@Override
	public List<BlankFillingQuestion> findAllBlankFillingQuestion() {
		return blankFillingQuestionMapper.selectAll();
	}

	@Override
	public List<EassyQuestion> findAllEassyQuestion() {
		return eassyQuestionMapper.selectAll();
	}

	@Override
	public String generateAnswer(int examID) {
		List<Integer> choiceQuestionID = findChoiceQuestionOfExam(examID);
		ChoiceQuestion choiceQuestion = new ChoiceQuestion();
		List<Integer> blankFillingQuestionID = findBlankFillingQuestionOfExam(examID);
		List<Integer> eassyQuestionID = findEassyQuestionOfExam(examID);
		EassyQuestion eassyQuestion = new EassyQuestion();
		
		StringBuilder save = new StringBuilder();
		save.append("标准答案如下：/n 一、选择题:/n");
		for(int i=1;i<=choiceQuestionID.size();i++){
			save.append(i+".");
			int choiceQuestionId = choiceQuestionID.get(i-1);
			choiceQuestion = choiceQuestionMapper.selectByPrimaryKey(choiceQuestionId);
			save.append(choiceQuestion.getAnswer()+"   ");
		}
		save.append("/n二、填空题：/n");
		List<BlankFillingAnswer> bfAnswer = null;
		for(int i=1;i<=blankFillingQuestionID.size();i++){
			save.append(i+".");
			int blankFillingQuestionId = blankFillingQuestionID.get(i-1);
			bfAnswer = blankFillingAnswerMapper.selectByQuestionID(blankFillingQuestionId);
			for(int j=1;j<=bfAnswer.size();j++){
				for(int k=0;k<bfAnswer.size();k++){
					if (j==bfAnswer.get(k).getOrders()) {
						save.append(bfAnswer.get(k).getAnswer());
					}
				}
			}
			
		}
		save.append("/n三、简答题：/n");
		for(int i=1;i<=eassyQuestionID.size();i++){
			save.append(i+".");
			int eassyQuestionId = eassyQuestionID.get(i-1);
			eassyQuestion = eassyQuestionMapper.selectByPrimaryKey(eassyQuestionId);
			save.append(eassyQuestion.getAnswer()+"    ");
		}
		TestPaper testPaper = testPaperMapper.selectByPrimaryKey(examID);
		testPaper.setAnswer(save.toString());
		return save.toString();
	}

	@Override
	public TestPaper findExamById(int  examId) {
		return  testPaperMapper.selectByPrimaryKey(examId);
	}

	@Override
	public List<Long> findStudentScoreBelow(int examId, int score) {
		return studentExamJunctionMapper.findStudentScoreBelow(examId, score);
	}

	@Override
	public List<Long> findStudentScoreHiger(int examId, int score) {
		return studentExamJunctionMapper.findStudentScoreHiger(examId, score);
	}

	@Override
	public List<Long> findStudentScoreBetween(int examId, int highScore, int lowScore) {
		return studentExamJunctionMapper.findStudentScoreBetween(examId, highScore, lowScore);
	}

	@Override
	public int findStudentScore(int examId, long studentId) {
		StudentExamJunctionKey key = new StudentExamJunctionKey();
		key.setExamId(examId);
		key.setStudentId(studentId);
		return studentExamJunctionMapper.selectByPrimaryKey(key).getScore();
	}

	@Override
	public List<StudentExamJunction> findStudentAllExamJunction(long studentId) {
		return studentExamJunctionMapper.findStudentAllExamJunction(studentId);
	}

	@Override
	public List<TestPaper> findAllExam() {
		return testPaperMapper.findAllExam();
	}

	@Override
	public List<TestPaper> findAllExamByTeacherCount(String count) {
		return testPaperMapper.findAllExamByTeacherCount(count);
	}

	@Override
	public int addStudentOfExam(int examId, long studentId) {
		StudentExamJunction record = new StudentExamJunction();
		record.setExamId(examId);
		record.setStudentId(studentId);
		return studentExamJunctionMapper.insert(record);
	}

	@Override
	public int changeStudentScore(int examId, long studentId, int score) {
		StudentExamJunction record = new StudentExamJunction();
		record.setExamId(examId);
		record.setStudentId(studentId);
		record.setScore(score);
		return studentExamJunctionMapper.updateByPrimaryKey(record);
	}

}

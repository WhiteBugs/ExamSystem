package com.gdut.ExamSystem.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gdut.ExamSystem.dao.BlankFillingAnswerMapper;
import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentJunctionMapper;
import com.gdut.ExamSystem.dao.BlankFillingJunctionMapper;
import com.gdut.ExamSystem.dao.BlankFillingQuestionMapper;
import com.gdut.ExamSystem.dao.ChoiceAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.ChoiceQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.ChoiceQuestionMapper;
import com.gdut.ExamSystem.dao.EassyAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.EassyQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.EassyQuestionMapper;
import com.gdut.ExamSystem.dao.TeacherMapper;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.model.BlankFillingAnswer;
import com.gdut.ExamSystem.model.BlankFillingAnswerKey;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunction;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunctionKey;
import com.gdut.ExamSystem.model.BlankFillingJunction;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.BlankFillingQuestionWithAnswers;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudent;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudentKey;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestionJunction;
import com.gdut.ExamSystem.model.EassyAnswerOfStudent;
import com.gdut.ExamSystem.model.EassyAnswerOfStudentKey;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.EassyQuestionJunction;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.TeacherService;


@Service("TeacherService") 
public class TeacherServiceImp implements TeacherService {
	@Resource(name="TeacherMapper")
	private TeacherMapper teacherMapper;
	
	@Resource(name="TestPaperMapper")
	private TestPaperMapper testPaperMapper;
	
	@Resource(name="ChoiceQuestionMapper")
	private ChoiceQuestionMapper choiceQuestionMapper;
	
	@Resource(name="BlankFillingAnswerMapper")
	private BlankFillingAnswerMapper blankFillingAnswerMapper;
	
	
	@Resource(name="BlankFillingQuestionMapper")
	private BlankFillingQuestionMapper blankFillingQuestionMapper;
	
	@Resource(name="EassyQuestionMapper")
	private EassyQuestionMapper eassyQuestionMapper;
	
	@Resource(name="ChoiceQuestionJunctionMapper")
	private ChoiceQuestionJunctionMapper choiceQuestionJunctionMapper;
	
	@Resource(name="BlankFillingJunctionMapper")
	private BlankFillingJunctionMapper blankFillingJunctionMapper;
	
	@Resource(name="EassyQuestionJunctionMapper")
	private EassyQuestionJunctionMapper eassyQuestionJunctionMapper;
	
	@Resource(name="ChoiceAnswerOfStudentMapper")
	private ChoiceAnswerOfStudentMapper choiceAnswerOfStudentMapper;
	
	@Resource(name="BlankFillingAnswerOfStudentJunctionMapper")
    private BlankFillingAnswerOfStudentJunctionMapper blankFillingAnswerOfStudentJunctionMapper;
	
	@Resource(name="EassyAnswerOfStudentMapper")
	private EassyAnswerOfStudentMapper eassyAnswerOfStudentMapper;
	
	@Override
	public int addTeacherCount(TeacherWithBLOBs teacher) {
		return teacherMapper.insertSelective(teacher);
	}

	@Override
	public int deleteTeacherByCount(String count) {
		return teacherMapper.deleteByPrimaryKey(count);
	}

	@Override
	public TeacherWithBLOBs findTeacherByCount(String count) {
		return teacherMapper.selectByPrimaryKey(count);
	}

	@Override
	public int changeTeacherPassword(String count,String password) {
		TeacherWithBLOBs teacher = teacherMapper.selectByPrimaryKey(count);
		teacher.setPassword(password);
		return teacherMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public int changeTeacherSafeQuesTion(String count,String question) {
		TeacherWithBLOBs teacher = teacherMapper.selectByPrimaryKey(count);
		teacher.setSafeQuestion(question);
		return teacherMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public int changeTeacherSafeAnswer(String count,String answer) {
		TeacherWithBLOBs teacher = teacherMapper.selectByPrimaryKey(count);
		teacher.setSafeAnswer(answer);
		return teacherMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public int updateAnswerOfChoiceQuestion(int choiceQuestionId, String answer) {
		ChoiceQuestion record = choiceQuestionMapper.selectByPrimaryKey(choiceQuestionId);
		record.setAnswer(answer);
		return choiceQuestionMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateAnswerOfBlankFillingQuestion(int blankFillingQuestionId, int orders, String answer) {
		BlankFillingAnswerKey key = new BlankFillingAnswerKey();
		key.setBlankFillingQuestionId(blankFillingQuestionId);
		key.setOrders(orders);
		BlankFillingAnswer record = blankFillingAnswerMapper.selectByPrimaryKey(key);
		record.setAnswer(answer);
		return blankFillingAnswerMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateAnswerOfEassyQuestion(int eassyQuestionId, String answer) {
		EassyQuestion record = eassyQuestionMapper.selectByPrimaryKey(eassyQuestionId);
		record.setAnswer(answer);
		return eassyQuestionMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int addChoiceQuestionOfExam(String examId, int choiceQuestionId, int order) {
		ChoiceQuestionJunction record = new ChoiceQuestionJunction();
		record.setChoiceQuestionId(choiceQuestionId);
		record.setExamId(examId);
		record.setOrders(order);
		return choiceQuestionJunctionMapper.insert(record);
	}

	@Override
	public int addBlankFillingQuestionOfExam(String examId, int blankFillingQuestionId, int order) {
		BlankFillingJunction record = new BlankFillingJunction();
		record.setTestPaperExamId(examId);
		record.setBlankFillingQuestionId(blankFillingQuestionId);
		record.setOrders(order);
		return blankFillingJunctionMapper.insert(record);
		
	}

	@Override
	public int addEassyQuestionOfExam(String examId, int eassyQuestionId, int order) {
		EassyQuestionJunction record = new EassyQuestionJunction();
		record.setEassyQuestionId(eassyQuestionId);
		record.setExamId(examId);
		record.setOrders(order);
		return eassyQuestionJunctionMapper.insert(record);
	}

	@Override
	public int updateChoiceQuestionScoreOfStudent(String examId, long studentId, int orders, int score) {
		ChoiceAnswerOfStudentKey key = new ChoiceAnswerOfStudentKey();
		key.setTestPaperExamId(examId);;
		key.setStudentId(studentId);
		key.setOrders(orders);
        ChoiceAnswerOfStudent record = choiceAnswerOfStudentMapper.selectByPrimaryKey(key);
        record.setScore(score);
        return choiceAnswerOfStudentMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateBlankFillingQuestionScoreOfStudent(String examId, long studentId, int orders, int score) {
		BlankFillingAnswerOfStudentJunctionKey key = new BlankFillingAnswerOfStudentJunctionKey();
		key.setTestPaperExamId(examId);
		key.setStudentId(studentId);
		key.setOrders(orders);
		BlankFillingAnswerOfStudentJunction record = blankFillingAnswerOfStudentJunctionMapper.selectByPrimaryKey(key);
		record.setScore(score);
		return blankFillingAnswerOfStudentJunctionMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateEassyQuestionScoreOfStudent(String examId, long studentId, int orders, int score) {
		EassyAnswerOfStudentKey key = new EassyAnswerOfStudentKey();
		key.setTestPaperExamId(examId);
		key.setStudentId(studentId);
		key.setOrders(orders);
		EassyAnswerOfStudent record = eassyAnswerOfStudentMapper.selectByPrimaryKey(key);
		record.setScore(score);
		return eassyAnswerOfStudentMapper.updateByPrimaryKey(record);
	}

	@Override
	public int getChoiceQuestionScoreOfStudent(String examId, long studentId) {
		List<ChoiceAnswerOfStudent> answerList = choiceAnswerOfStudentMapper.selectStudentAllChoiceAnswer(examId, studentId);
		int score = 0;
		for(ChoiceAnswerOfStudent answer : answerList){
			score+=answer.getScore();
		}
		return score;
	}

	@Override
	public int getBlankFillingQuestionScoreOfStudent(String examId, long studentId) {
		List<BlankFillingAnswerOfStudentJunction> answerList = blankFillingAnswerOfStudentJunctionMapper.selectStudentAllBlankFillingAnswerJunction(examId, studentId);
		int score = 0;
		for(BlankFillingAnswerOfStudentJunction answer : answerList){
			score+=answer.getScore();
		}
		return score;
	}

	@Override
	public int getEassyQuestionScoreOfStudent(String examId, long studentId) {
		List<EassyAnswerOfStudent> answerList = eassyAnswerOfStudentMapper.selectStudentAllEassyAnswer(examId, studentId);
		int score = 0;
		for(EassyAnswerOfStudent answer : answerList){
			score+=answer.getScore();
		}
		return score;
	}

	@Override
	public List<Teacher> findAllTeacher() {
		List<Teacher> teacherList = teacherMapper.selectAllTeacher();
		return teacherList;
	}

	@Override
	public int addChoiceQuestionIntoDB(ChoiceQuestion choiceQuestion) {
		choiceQuestionMapper.insert(choiceQuestion);
		return 0;
	}

	@Override
	@Transactional
	public int addBlankFillingQuestionIntoDB(BlankFillingQuestion blankFillingQuestion, String[] answers) {
		try{
			blankFillingQuestionMapper.insert(blankFillingQuestion);
			int id = blankFillingQuestion.getBlankFillingQuestionId();
			System.out.println("------------------id  is "+id);
			for(int i=1;i<=answers.length;i++){
				BlankFillingAnswer answer = new BlankFillingAnswer();
				answer.setBlankFillingQuestionId(id);
				answer.setAnswer(answers[i-1]);
				answer.setOrders(i);
				blankFillingAnswerMapper.insert(answer);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int addEassyQuestionIntoDB(EassyQuestion eassyQuestion) {
		eassyQuestionMapper.insert(eassyQuestion);
		return 0;
	}

	@Override
	public ChoiceQuestion findChoiceQuestionById(int id) {
		return choiceQuestionMapper.selectByPrimaryKey(id);
	}

	@Override
	public BlankFillingQuestionWithAnswers findBlankFillingQuestionById(int id) {
		BlankFillingQuestionWithAnswers blankFillingQuestion = new BlankFillingQuestionWithAnswers();
		blankFillingQuestion.setBlankFillingQuestionId(id);
		blankFillingQuestion.setTitle(blankFillingQuestionMapper.selectByPrimaryKey(id).getTitle());
		blankFillingQuestion.setAnswers(blankFillingAnswerMapper.selectByQuestionID(id));
		return blankFillingQuestion;
	}

	@Override
	public EassyQuestion findEassyQuestionById(int id) {
		return eassyQuestionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateChoiceQuestion(ChoiceQuestion choiceQuestion) {
		return choiceQuestionMapper.updateByPrimaryKey(choiceQuestion);
	}

	@Override
	public int updateBlankFillingQuestion(BlankFillingQuestion blankFillingQuestion) {
		System.out.println("-----------------------还未补坑--------------------------");
		return 0;
	}

	@Override
	public int updateEassyQuestion(EassyQuestion eassyQuestion) {
		return eassyQuestionMapper.updateByPrimaryKeyWithBLOBs(eassyQuestion);
	}
}

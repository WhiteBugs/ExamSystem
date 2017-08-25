package com.gdut.ExamSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gdut.ExamSystem.dao.BlankFillingAnswerMapper;
import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentJunctionMapper;
import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.BlankFillingJunctionMapper;
import com.gdut.ExamSystem.dao.BlankFillingQuestionMapper;
import com.gdut.ExamSystem.dao.ChoiceAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.ChoiceQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.ChoiceQuestionMapper;
import com.gdut.ExamSystem.dao.CountExamJunctionMapper;
import com.gdut.ExamSystem.dao.EassyAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.EassyQuestionJunctionMapper;
import com.gdut.ExamSystem.dao.EassyQuestionMapper;
import com.gdut.ExamSystem.dao.ExamInfoMapper;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.dao.TestPaperMapper;
import com.gdut.ExamSystem.enums.QuestionType;
import com.gdut.ExamSystem.model.BlankFillingAnswer;
import com.gdut.ExamSystem.model.BlankFillingJunction;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.BlankFillingQuestionWithAnswers;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudent;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudentKey;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestionJunction;
import com.gdut.ExamSystem.model.ChoiceQuestionJunctionKey;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.EassyQuestionJunction;
import com.gdut.ExamSystem.model.ExamInfo;
import com.gdut.ExamSystem.model.ExamInfoKey;
import com.gdut.ExamSystem.model.Question;
import com.gdut.ExamSystem.model.Student;
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
	
	@Resource(name="ChoiceAnswerOfStudentMapper")
	private ChoiceAnswerOfStudentMapper choiceAnswerOfStudentMapper;
	
	@Resource(name="BlankFillingAnswerOfStudentMapper")
	private BlankFillingAnswerOfStudentMapper blankFillingAnswerOfStudentMapper;
	
	@Resource(name="BlankFillingAnswerOfStudentJunctionMapper")
	private BlankFillingAnswerOfStudentJunctionMapper blankFillingAnswerOfStudentJunctionMapper;
	
	@Resource(name="EassyAnswerOfStudentMapper")
	private EassyAnswerOfStudentMapper eassyAnswerOfStudentMapper;
	
	@Resource(name="StudentExamJunctionMapper")
	private StudentExamJunctionMapper studentExamJunctionMapper;
	
	@Resource(name="CountExamJunctionMapper")
	private CountExamJunctionMapper countExamJunctionMapper;
	
	@Resource(name="ExamInfoMapper")
	private ExamInfoMapper examInfoMapper;
	
	@Override
	public List<ChoiceQuestion> findChoiceQuestionOfExam(String examID) {
		List<ChoiceQuestionJunction> choices = choiceQuestionJunctionMapper.findAllChoiceQuestionOfExam(examID);
		List<ChoiceQuestion> choiceQuestions = new ArrayList<>();
		for(ChoiceQuestionJunction choice : choices){
			choiceQuestions.add(choiceQuestionMapper.selectByPrimaryKey(choice.getChoiceQuestionId()));
		}
		return choiceQuestions;
	}

	@Override 
	public List<BlankFillingQuestionWithAnswers> findBlankFillingQuestionOfExam(String examID) {
		List<BlankFillingJunction> blanks = blankFillingJunctionMapper.findAllBlankFillingQuestionOfExam(examID);
		List<BlankFillingQuestionWithAnswers> blankFillingQuestions = new ArrayList<>();
		for(BlankFillingJunction blank  : blanks){
			int blankFillingQuestionId = blank.getBlankFillingQuestionId();
			BlankFillingQuestionWithAnswers item = new BlankFillingQuestionWithAnswers();
			item.setBlankFillingQuestionId(blankFillingQuestionId);
			item.setTitle(blankFillingQuestionMapper.selectByPrimaryKey(blankFillingQuestionId).getTitle());
			item.setAnswers(blankFillingAnswerMapper.selectByQuestionID(blankFillingQuestionId));
			blankFillingQuestions.add(item);
		}
		return blankFillingQuestions;
	}

	@Override
	public List<EassyQuestion> findEassyQuestionOfExam(String examID) {
		List<EassyQuestionJunction> eassyQuestion = eassyQuestionJunctionMapper.findAllEassyQuestionOfExam(examID);
		List<EassyQuestion> eassyQuestions = new ArrayList<>();
		for(EassyQuestionJunction eassy : eassyQuestion){
			eassyQuestions.add(eassyQuestionMapper.selectByPrimaryKey(eassy.getEassyQuestionId()));
		}
		return eassyQuestions;
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
	public List<BlankFillingQuestionWithAnswers> findAllBlankFillingQuestion() {
		List<BlankFillingQuestion> blank = blankFillingQuestionMapper.selectAll();
		List<BlankFillingQuestionWithAnswers> blankFillingQuestions = new ArrayList<>();
		for(int i=0;i<blank.size();i++){
			BlankFillingQuestionWithAnswers item = new BlankFillingQuestionWithAnswers();
			item.setBlankFillingQuestionId(blank.get(i).getBlankFillingQuestionId());
			item.setTitle(blank.get(i).getTitle());
			item.setAnswers(blankFillingAnswerMapper.selectByQuestionID(blank.get(i).getBlankFillingQuestionId()));
			blankFillingQuestions.add(item);
		}
		
		return blankFillingQuestions;
	}

	@Override
	public List<EassyQuestion> findAllEassyQuestion() {
		return eassyQuestionMapper.selectAll();
	}

	@Override
	public String generateAnswer(String examID) {
		List<ChoiceQuestionJunction> choiceQuestionID = choiceQuestionJunctionMapper.findAllChoiceQuestionOfExam(examID);
		ChoiceQuestion choiceQuestion = new ChoiceQuestion();
		List<BlankFillingJunction> blankFillingQuestionID = blankFillingJunctionMapper.findAllBlankFillingQuestionOfExam(examID);
		List<EassyQuestionJunction> eassyQuestionID = eassyQuestionJunctionMapper.findAllEassyQuestionOfExam(examID);
		EassyQuestion eassyQuestion = new EassyQuestion();
		
		StringBuilder save = new StringBuilder();
		save.append("标准答案如下：/n 一、选择题:/n");
		for(int i=1;i<=choiceQuestionID.size();i++){
			save.append(i+".");
			int choiceQuestionId = choiceQuestionID.get(i-1).getChoiceQuestionId();
			choiceQuestion = choiceQuestionMapper.selectByPrimaryKey(choiceQuestionId);
			save.append(choiceQuestion.getAnswer()+"   ");
		}
		save.append("/n二、填空题：/n");
		List<BlankFillingAnswer> bfAnswer = null;
		for(int i=1;i<=blankFillingQuestionID.size();i++){
			save.append(i+".");
			int blankFillingQuestionId = blankFillingQuestionID.get(i-1).getBlankFillingQuestionId();
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
			int eassyQuestionId = eassyQuestionID.get(i-1).getEassyQuestionId();
			eassyQuestion = eassyQuestionMapper.selectByPrimaryKey(eassyQuestionId);
			save.append(eassyQuestion.getAnswer()+"    ");
		}
		TestPaper testPaper = testPaperMapper.selectByPrimaryKey(examID);
		testPaper.setAnswer(save.toString());
		return save.toString();
	}

	@Override
	public TestPaper findExamById(String  examId) {
		return  testPaperMapper.selectByPrimaryKey(examId);
	}

	@Override
	public List<Long> findStudentScoreBelow(String examId, int score) {
		return studentExamJunctionMapper.findStudentScoreBelow(examId, score);
	}

	@Override
	public List<Long> findStudentScoreHiger(String examId, int score) {
		return studentExamJunctionMapper.findStudentScoreHiger(examId, score);
	}

	@Override
	public List<Long> findStudentScoreBetween(String examId, int highScore, int lowScore) {
		return studentExamJunctionMapper.findStudentScoreBetween(examId, highScore, lowScore);
	}

	@Override
	public int findStudentScore(String examId, long studentId) {
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
		List<String> examIds = countExamJunctionMapper.findAllExamByTeacherCount(count);
		List<TestPaper> exams = new ArrayList<>();
		for(String examId : examIds){
			exams.add(testPaperMapper.selectByPrimaryKey(examId));
		}
		return exams;
	}

	@Override
	public int addStudentOfExam(String examId, long studentId) {
		StudentExamJunction record = new StudentExamJunction();
		record.setExamId(examId);
		record.setStudentId(studentId);
		record.setScore(-2);
		return studentExamJunctionMapper.insert(record);
	}

	@Override
	public int changeStudentScore(String examId, long studentId, int score) {
		StudentExamJunction record = new StudentExamJunction();
		record.setExamId(examId);
		record.setStudentId(studentId);
		record.setScore(score);
		return studentExamJunctionMapper.updateByPrimaryKey(record);
	}

	@Override
	public Map findQuestionAnswer(String examId, QuestionType type) {
		TreeMap<Integer, String> answer = new TreeMap<>();
		switch (type.toString()) {
		case "choiceQuestion":
			for(ChoiceQuestionJunction item : choiceQuestionJunctionMapper.findAllChoiceQuestionOfExam(examId)){
				answer.put(item.getOrders(), choiceQuestionMapper.selectByPrimaryKey(item.getChoiceQuestionId()).getAnswer());
			}
			return answer;
			
		case "multipleChoiceQuestion":
			
			return answer;
			
		case "trueFalseQuestion":
			
			return answer;
			
		case "blankFillingQuestion":
			for(BlankFillingJunction item : blankFillingJunctionMapper.findAllBlankFillingQuestionOfExam(examId)){
				List<BlankFillingAnswer> answerItems = blankFillingAnswerMapper.selectByQuestionID(item.getBlankFillingQuestionId());
				TreeMap<Integer, String> answerItem = new TreeMap<>();
				for(int i=0; i<answerItems.size(); i++){
					answerItem.put(answerItems.get(i).getOrders(), answerItems.get(i).getAnswer());
				}
				StringBuilder save = new StringBuilder();
				for(int i=1; i<answerItem.size()+1; i++ ){
					save.append(answerItem.get(i));
					save.append("  ");
				}
				answer.put(item.getOrders(), save.toString());
			}
			return answer;
			
		case "eassyQuestion":
			for(EassyQuestionJunction item : eassyQuestionJunctionMapper.findAllEassyQuestionOfExam(examId)){
				answer.put(item.getOrders(), eassyQuestionMapper.selectByPrimaryKey(item.getEassyQuestionId()).getAnswer());
			}
			return answer;
		default:
			break;
		}
		
		return null;
	}

	@Override
	public int addQuestionScore(ExamInfo examInfo) {
		return examInfoMapper.insert(examInfo);
	}

	@Override
	public ExamInfo findQuestionScoreOfExam(String examId, String questionType) {
		ExamInfoKey key = new ExamInfoKey();
		key.setTestPaperExamId(examId);
		key.setQuestionType(questionType);
		return examInfoMapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Long> findAllStudentIdByExamId(String examId) {
		return studentExamJunctionMapper.findAllStudentIDByExamID(examId);
	}

	@Override
	public int findQuestionIdOfExam(String examId, int order, QuestionType type) {
		switch (type.toString()) {
		case "choiceQuestion":
			return choiceQuestionJunctionMapper.findQuestionId(examId, order);
			
		case "multipleChoiceQuestion":
			
			break;
		case "trueFalseQuestion":
			
			break;
		case "blankFillingQuestion":
			return blankFillingJunctionMapper.findQuestionId(examId, order);
		case "eassyQuestion":
			return eassyQuestionJunctionMapper.findQuestionId(examId, order);
		default:
			break;
		}
		return -1;
	}

	@Override
	public List findQuestionWithStudentAnswer(String examId, String studentID, QuestionType type) {
		long studentId = Long.parseLong(studentID);
		switch (type.toString()) {
		case "choiceQuestion":
			List<Question> questions = new ArrayList<>();
			List<ChoiceQuestion> choiceQuestions = findChoiceQuestionOfExam(examId);
			for(int i=0; i<choiceQuestions.size(); i++){
				ChoiceQuestion item = choiceQuestions.get(i); 
				Question question = new Question();
				question.setTitle(item.getTitle());
				question.setAnswer(item.getAnswer());
				question.setChoice1(item.getChoice1());
				question.setChoice2(item.getChoice2());
				question.setChoice3(item.getChoice3());
				question.setChoice4(item.getChoice4());
				question.setQuestionId(item.getChoiceQuestionId());
				question.setQuestionType(QuestionType.choiceQuestion.toString());
				ChoiceAnswerOfStudentKey key = new ChoiceAnswerOfStudentKey();
				key.setOrders(i+1);
				key.setStudentId(studentId);
				key.setTestPaperExamId(examId);
				ChoiceAnswerOfStudent answer = choiceAnswerOfStudentMapper.selectByPrimaryKey(key);
				if(answer != null){
					question.setStudentAnswer(answer.getAnswer());
					question.setStudentScore(answer.getScore());
					question.setOrder(answer.getOrders());
				}else{
					question.setStudentAnswer("没有作答");
					question.setStudentScore(0);
					question.setOrder(answer.getOrders());
				}
				questions.add(question);
			}
			return questions;
		case "multipleChoiceQuestion":
			
			break;
		case "trueFalseQuestion":
			
			break;
		case "blankFillingQuestion":
			
		case "eassyQuestion":
			
		default:
			break;
		}
		return null;
	}

}

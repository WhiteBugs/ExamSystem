package com.gdut.ExamSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentJunctionMapper;
import com.gdut.ExamSystem.dao.BlankFillingAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.ChoiceAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.EassyAnswerOfStudentMapper;
import com.gdut.ExamSystem.dao.StudentExamJunctionMapper;
import com.gdut.ExamSystem.dao.StudentMapper;
import com.gdut.ExamSystem.enums.QuestionType;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudent;
import com.gdut.ExamSystem.model.BlankFillingAnswerOfStudentJunction;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudent;
import com.gdut.ExamSystem.model.EassyAnswerOfStudent;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.service.StudentService;


@Service("StudentService")
public class StudentServiceImp implements StudentService {
	
	@Resource(name="StudentMapper")
	private StudentMapper studentMapper;
	
	@Resource(name="StudentExamJunctionMapper")
	private StudentExamJunctionMapper studentExamJunctionMapper;
	
	@Resource(name="ChoiceAnswerOfStudentMapper")
	private ChoiceAnswerOfStudentMapper choiceAnswerOfStudentMapper;
	
	@Resource(name="BlankFillingAnswerOfStudentMapper")
	private BlankFillingAnswerOfStudentMapper blankFillingAnswerOfStudentMapper;
	
	@Resource(name="BlankFillingAnswerOfStudentJunctionMapper")
	private BlankFillingAnswerOfStudentJunctionMapper blankFillingAnswerOfStudentJunctionMapper;
	
	@Resource(name="EassyAnswerOfStudentMapper")
	private EassyAnswerOfStudentMapper eassyAnswerOfStudentMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);

	@Override
	public void add(Student student) {
		logger.debug("进入service层");
		studentMapper.insert(student);
	}

	@Override
	public void delete(Student student) {
		logger.debug("进入service层");
		studentMapper.deleteOne(student);	
	}

	@Override
	public void deleteByGrade(int grade) {
		logger.debug("进入service层");
		studentMapper.deleteByGrade(grade);
	}

	@Override
	public void deleteByStudentID(long studentID) {
		logger.debug("进入service层");
		studentMapper.deleteByPrimaryKey(studentID);
	}

	@Override
	public void deleteByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层");
		studentMapper.deleteByExamineeNumber(examineeNumber);
	}

	@Override
	public void delettByClass(int classes) {
		logger.debug("进入service层");
		studentMapper.deleteByClass(classes);
	}

	@Override
	public Student findStudentByStudentID(long studentID) {
		logger.debug("进入service层");
		return studentMapper.selectByStudentId(studentID);
	}

	@Override
	public Student findStudentByExamineeNumber(long examineeNumber) {
		logger.debug("进入service层");
		return studentMapper.selectByExamineeNumber(examineeNumber);
	}

	@Override
	public ArrayList<Student> findStudentByName(String name) {
		logger.debug("进入service层");
		return (ArrayList<Student>)studentMapper.selectByName(name);
	}

	@Override
	public ArrayList<Student> findStudentByClasses(int classes) {
		logger.debug("进入service层");
		return (ArrayList<Student>)studentMapper.selectByClass(classes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> findStudentByMajor(String[] majors) {
		logger.debug("进入service层");
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Student> temp;
		for(String major : majors){
			if((temp=(ArrayList<Student>)studentMapper.selectByMajor(major))!=null){
				for(Student student : temp){
					students.add(student);
				}
				temp=null;
			}
		}
		return students;
	}

	@Override
	public void changeStudentExamineeNumber(long ExamineeNumber, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setExamineeNumber(ExamineeNumber);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentName(String name, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setName(name);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentSex(String sex, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setSex(sex);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentGrade(int grade, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setGrade(grade);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentClasses(int classes, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setClasses(classes);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentMajor(String major, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setMajor(major);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public void changeStudentPassword(String password, Student student) {
		logger.debug("进入service层");
		Student student2 = studentMapper.selectByPrimaryKey(student.getStudentId());
		student2.setPassword(password);
		studentMapper.updateByPrimaryKeySelective(student2);
	}

	@Override
	public boolean isStudentExist(long studentID) {
		if(findStudentByStudentID(studentID)!=null){
			return true;
		}else
		return false;
	}

	@Override
	public List<String> findStudentExamID(long studentID) {
		List<String> examIdList = new ArrayList<>();
		for(StudentExamJunction examJunction : studentExamJunctionMapper.findStudentAllExamJunction(studentID)){
			examIdList.add(examJunction.getExamId());
		}
		return examIdList;
	}

	@Override
	public List<Student> findAllStudent() {
		return studentMapper.selectAll();
	}

	@Override
	public ArrayList<Student> findStudentByMajorAndClasses(String major, int classes) {
		ArrayList<Student> students = new ArrayList<>();
		String[] majors = {major};
		students = findStudentByMajor(majors);
		for(int i=0;i<students.size();i++){
			if(students.get(i).getClasses()!=classes){
				students.remove(i);
				if(students.size()==i){
					break;
				}
			}
		}
		return students;
	}

	@Override
	public List<Integer> findClassesByMajor(String major) {
		return studentMapper.selectClassesByMajor(major);
	}

	@Override
	public List<String> findAllMajor() {
		return studentMapper.selectAllMajor();
	}

	@Override
	public int addAnswer(long studentId, String examId, String answer, int order, QuestionType type) {
		
		switch (type.toString()) {
		case "choiceQuestion":
			ChoiceAnswerOfStudent choiceAnswer = new ChoiceAnswerOfStudent();
			choiceAnswer.setAnswer(answer);
			choiceAnswer.setOrders(order);
			choiceAnswer.setScore(-1);
			choiceAnswer.setStudentId(studentId);
			choiceAnswer.setTestPaperExamId(examId);
			return choiceAnswerOfStudentMapper.insert(choiceAnswer);
		case "multipleChoiceQuestion":
			
			break;
		case "trueFalseQuestion":
			
			break;
		case "blankFillingQuestion":
			String[] answers = answer.split("\\s+");
			try{
				for(int i=1;i<answers.length+1;i++){
					BlankFillingAnswerOfStudent blankAnswer = new BlankFillingAnswerOfStudent();
					blankAnswer.setAnswer(answers[i-1]);
					blankAnswer.setOrders(i);
					blankFillingAnswerOfStudentMapper.insert(blankAnswer);
					BlankFillingAnswerOfStudentJunction junction = new BlankFillingAnswerOfStudentJunction();
					junction.setBlankFillingAnswerIdOfStudent(blankAnswer.getBlankFillingAnswerId());;
					junction.setOrders(order);
					junction.setScore(-1);
					junction.setStudentId(studentId);
					junction.setTestPaperExamId(examId);
					blankFillingAnswerOfStudentJunctionMapper.insert(junction);
				}
				return 0;
			}catch (Exception e) {
				return -1;
			}
		case "eassyQuestion":
			EassyAnswerOfStudent eassyAnswer = new EassyAnswerOfStudent();
			eassyAnswer.setAnswer(answer);
			eassyAnswer.setOrders(order);
			eassyAnswer.setScore(-1);
			eassyAnswer.setStudentId(studentId);
			eassyAnswer.setTestPaperExamId(examId);
			return eassyAnswerOfStudentMapper.insert(eassyAnswer);
		default:
			System.out.println("-------没有这种问题类型-----------");
			break;
		}
		return 0;
	}
}

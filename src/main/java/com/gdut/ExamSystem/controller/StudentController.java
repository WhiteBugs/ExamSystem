package com.gdut.ExamSystem.controller;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gdut.ExamSystem.enums.QuestionType;
import com.gdut.ExamSystem.model.BlankFillingQuestionWithAnswers;
import com.gdut.ExamSystem.model.ChoiceAnswerOfStudent;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.ExamInfo;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.StudentExamJunction;
import com.gdut.ExamSystem.model.StudentExamJunctionKey;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.ExamService;
import com.gdut.ExamSystem.service.StudentService;
@Controller
@RequestMapping(value="student")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Resource(name="ExamService")
	private ExamService examService;
	
	
	@Resource(name="StudentService")
	private StudentService studentService;
	
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public ModelAndView Welcome(HttpServletRequest request, HttpServletResponse response){
		Student student = (Student) request.getSession().getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", student);
		modelAndView.setViewName("student/studentWelcome");
		return modelAndView;
	} 
	
	@RequestMapping(value="exam")
	public ModelAndView Exam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		Student student = (Student) request.getSession().getAttribute("user");
		List<String> examId = studentService.findStudentExamID(student.getStudentId());
		ArrayList<TestPaper> examList = new ArrayList<>();
		if(examId!=null)
			for(String examid : examId){
				examList.add(examService.findExamById(examid));
			} 
		model.addObject("examList", examList);
		
		model.setViewName("student/exam/examList");
		return model;
	}
	
	@RequestMapping(value="exam/commit")
	@Transactional
	public ModelAndView examCommit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("student/info");
		Student student = (Student) request.getSession().getAttribute("user");
		String examId = request.getParameter("examId");
		if(student == null){
			//model.setViewName("student/info");
			model.addObject("info", "Session 中没有user元素");
			return model;
		}
		if(examId == null){
			//model.setViewName("student/info");
			model.addObject("info", "--------- examId  is  null -------");
			return model;
		}
		long studentId = student.getStudentId();
		try{
			String choiceQuestionSize = request.getParameter("choiceQuestionSize");
			if(choiceQuestionSize !=null){
				int choiceSize = Integer.parseInt(choiceQuestionSize);
				for(int i=0;i<choiceSize;i++){
					String answer1 = request.getParameter("choiceQuestionAnswer"+i);
					studentService.addAnswer(studentId, examId, answer1, i+1, QuestionType.choiceQuestion);
				}
			}
			String multipleChoiceQuestionSize = request.getParameter("multipleChoiceQuestionSize");
			if(multipleChoiceQuestionSize!=null){
				int multipleSize = Integer.parseInt(multipleChoiceQuestionSize);
				for(int i=0;i<multipleSize;i++){
					String answer2 = request.getParameter("multipleChoiceAnswer"+i);
					studentService.addAnswer(studentId, examId, answer2, i+1, QuestionType.multipleChoiceQuestion);
				}
			}
			String tureFalseQuestionSize = request.getParameter("tureFalseQuestionSize");
			if(tureFalseQuestionSize!=null){
				System.out.println("------StudentController  examCommit-----判断题还没写逻辑---------");
			}
			String blankFillingQuestionSize = request.getParameter("blankFillingQuestionSize");
			if(blankFillingQuestionSize != null){
				int blankSize = Integer.parseInt(blankFillingQuestionSize);
				for(int i = 0; i <blankSize; i++){
					String answer4 = request.getParameter("blankQuestionAnswer"+i);
					studentService.addAnswer(studentId, examId, answer4, i+1, QuestionType.blankFillingQuestion);
				}
			}
			String eassyQuestionSize = request.getParameter("eassyQuestionSize");
			if(eassyQuestionSize != null){
				int eassySize = Integer.parseInt(eassyQuestionSize);
				for(int i=0; i <eassySize; i++){
					String answer5 = request.getParameter("eassyQuestionAnswer"+i);
					studentService.addAnswer(studentId, examId, answer5, i+1, QuestionType.eassyQuestion);
				}
			}
			//model.setViewName("student/info");
			model.addObject("info", "提交成功");
			examService.changeStudentScore(examId, studentId, 0);
		}catch (Exception e) {
			//model.setViewName("student/info");
			model.addObject("info", "提交失败");
		}
		return model;
	}
	
	@RequestMapping(value="enterExam")
	public ModelAndView enterExam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("exam/examTemplet");
		String examId = request.getParameter("examId");
		Student student = (Student) request.getSession().getAttribute("user");
		if(examId==null){
			model.setViewName("student/info");
			model.addObject("info", "没有获得试卷ID");
			return model;
		}
		TestPaper exam = examService.findExamById(examId);
		if(student == null){
			model.setViewName("student/info");
			model.addObject("info", "没有获得学生user");
			return model;
		}
		int score = examService.findStudentScore(examId, student.getStudentId());
		if(score >= -1){
			model.setViewName("student/info");
			model.addObject("info", "这门考试你已经考过了");
			return model;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		if(exam.getBeginTime().getTime()>currentTime.getTime()){
			model.setViewName("student/info");
			model.addObject("info", "还未到考试开放时间");
			return model;
		}else if(currentTime.getTime() > exam.getEndTime().getTime()){
			model.setViewName("student/info");
			model.addObject("info", "考试开放时间已过");
			return model;
		}
		File dir = new File(request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/view/exam/"+examId+"/"+examId+".html");
		if(dir.exists()){
			System.out.println("采用了静态页面------路径是"+dir.getPath());
			model.setViewName("exam/"+examId+"/"+examId);
			return model;
		}else{
			model.addObject("exam", exam);
			List<ChoiceQuestion> choiceQuestions = examService.findChoiceQuestionOfExam(examId);
			if(choiceQuestions!=null&&choiceQuestions.size()>0){
				model.addObject("choiceQuestions", choiceQuestions);
			}
			List<BlankFillingQuestionWithAnswers> blankFillingQuestions = examService.findBlankFillingQuestionOfExam(examId);
			if(blankFillingQuestions!=null&&blankFillingQuestions.size()>0){
				model.addObject("blankFillingQuestions", blankFillingQuestions);
			}
			List<EassyQuestion> eassyQuestions = examService.findEassyQuestionOfExam(examId);
			if(eassyQuestions!=null&&eassyQuestions.size()>0){
				model.addObject("eassyQuestions", eassyQuestions);
			}
			
			model.addObject("time", exam.getExamTime());
		}
		return model;
	}

	
	@RequestMapping(value="studentInfo")
	public ModelAndView StudentInfo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		model.setViewName("student/studentInfo");
		Student student = (Student) request.getSession().getAttribute("user");
		model.addObject("user", student);
		return model;
	}
	
	@RequestMapping(value="scoreCheck")
	public ModelAndView scoreCheck(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("student/exam/examScore");
		Student student = (Student)request.getSession().getAttribute("user");
		long studentId = student.getStudentId();
		
	    List<StudentExamJunction> examJunctionList = examService.findStudentAllExamJunction(studentId);
	    List<ExamInfo> examList = new ArrayList<>();
	    for(StudentExamJunction examJunction : examJunctionList){
	    	String examName = examService.findExamById(examJunction.getExamId()).getExamName();
	    	int score = examJunction.getScore();
	    	ExamInfo examInfo = new ExamInfo();
	    	examInfo.setExamName(examName);
	    	examInfo.setScore(score);
	    	examList.add(examInfo);
	    }
	    for(ExamInfo examInfo : examList){
	    	System.out.print("---------------"+examInfo.getExamName()+"   "+examInfo.getScore()+"-------------");
	    }
	    model.addObject("examList", examList);
		return model;
	}
	
	
	@RequestMapping(value="exam/examList")
	public ModelAndView ExamLsit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		model.setViewName("student/exam/exmaList");
		
		return model;
	}
	
	@RequestMapping(value="exam/examList/**/startExam")
	public ModelAndView StartExam(HttpServletRequest reqie){
		ModelAndView model = new ModelAndView();
		
		model.setViewName("student/exam/examList/exam");
		return model;
	}
	
	@RequestMapping(value="exam/examList/**/startExam/return")
	public ModelAndView ReturnUp(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		
		return model;
	}
	
	
}


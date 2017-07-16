package com.gdut.ExamSystem.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		List<Integer> examId = studentService.findStudentExamID(student.getStudentId());
		ArrayList<TestPaper> examList = new ArrayList<>();
		if(examId!=null)
			for(int examid : examId){
				examList.add(examService.findExamById(examid));
			} 
		model.addObject("examList", examList);
		
		model.setViewName("student/exam/examList");
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


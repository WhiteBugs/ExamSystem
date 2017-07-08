package com.gdut.ExamSystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.service.ExamService;
import com.gdut.ExamSystem.service.StudentService;

@Controller
@RequestMapping(value="/Student")
public class InfoController {
	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Resource(name="StudentService")
    private StudentService studentService;
    
    @Resource(name="ExamService")
    private ExamService examService;
	
    
	@RequestMapping(value="/studentInfo",method=RequestMethod.GET)
	public ModelAndView returnStudentInfo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("login/studentinfo");
		Student student = (Student) request.getSession().getAttribute("user");
		model.addObject("studentId", student.getStudentId());
		model.addObject("sex", student.getSex());
		model.addObject("examineeNumber", student.getExamineeNumber());
		model.addObject("id", student.getId());
		model.addObject("classes", student.getClasses());
		model.addObject("major", student.getMajor());
		model.addObject("name", student.getName());
		return model;
	}
	
	@RequestMapping(value="/examInfo",method=RequestMethod.GET)
	public ModelAndView returnExamInfo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("");
		return model;
	}
	
	@RequestMapping(value="/examList",method=RequestMethod.GET)
	public ModelAndView returnExamList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("/ExamSystem/login.jsp");
		Student student = (Student) request.getSession().getAttribute("user");
		if(student==null)
			return model;
		List<Integer> studentExam = studentService.findStudentExamID(student.getStudentId());
		ArrayList<String> examName = new ArrayList<String>();
		for(int examId : studentExam){
			examName.add(examService.findExamById(examId).getExamName());
		}
		model.addObject("examName", examName);
		model.setViewName("");
		
		
		return model;
	}
	
	@RequestMapping(value="/scoreCheck",method=RequestMethod.GET)
	public ModelAndView returnStudentScore(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("");
		return model;
	}
	
}

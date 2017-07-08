package com.gdut.ExamSystem.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.ExamService;


@Controller
@RequestMapping(value="teacher")
public class TeacherController {
	
	
	@Resource(name="ExamService")
	private ExamService examService;
	
	
	@RequestMapping(value="teacherWelcome")
	public ModelAndView TeacherWelcome(HttpServletRequest request){
		Teacher teacher = (Teacher)request.getSession().getAttribute("user");
		ModelAndView model = new ModelAndView();
		model.addObject("user", teacher);
		List<TestPaper> examList = examService.findAllExamByTeacherCount(teacher.getCount());
		model.addObject("examList", examList);
		model.setViewName("teacher/teacherWelcome");
		return model;
		
	}
	
	@RequestMapping(value="exam")
	public ModelAndView Exam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/exam/examList");
		Teacher teacher = (Teacher)request.getSession().getAttribute("user");
		List<TestPaper> examList = examService.findAllExamByTeacherCount(teacher.getCount());
		model.addObject("examList", examList);
		return model;
	}
	
	
	
	
}

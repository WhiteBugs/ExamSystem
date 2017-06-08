package com.gdut.ExamSystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.AdminService;
import com.gdut.ExamSystem.service.ExamService;



@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Resource(name="ExamService")
	private ExamService examService;
	
	@Resource(name="AdminService")
	private AdminService adminService;
	
	@RequestMapping(value="adminWelcome")
	public ModelAndView adminWelcome(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/adminWelcome");
		Adminstrator admin = (Adminstrator)request.getSession().getAttribute("user");
		model.addObject("user", admin);
		return model;
	}
	
	
	@RequestMapping(value="addExam")
	public ModelAndView addExam(HttpServletRequest requests, HttpServletResponse response){
		return new ModelAndView("admin/addExam");
	}
	
	@RequestMapping(value="manageTeacher")
	public ModelAndView manageTeacher(HttpServletRequest requests, HttpServletResponse response){
		return new ModelAndView("admin/manageTeacher");
 	}
	
	@RequestMapping(value="manageStudent")
	public ModelAndView manageStudent(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("admin/manageStudent");
	}
	
	@RequestMapping(value="manageExam")
	public ModelAndView manageExam(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("admin/manageExam");
	}
	
	
	
}

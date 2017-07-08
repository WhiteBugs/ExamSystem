package com.gdut.ExamSystem.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.AdminService;
import com.gdut.ExamSystem.service.ExamService;
import com.gdut.ExamSystem.service.StudentService;
import com.gdut.ExamSystem.service.TeacherService;



@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Resource(name="ExamService")
	private ExamService examService;
	
	@Resource(name="AdminService")
	private AdminService adminService;
	
	@Resource(name="TeacherService")
	private TeacherService teacherService;
	
	@Resource(name="StudentService")
	private StudentService studentService;
	
	
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
		List<Teacher> teacherList = teacherService.findAllTeacher();
		ModelAndView model = new ModelAndView("admin/manageTeacher");
		model.addObject("teacherList", teacherList);
		return model;
 	}
	
	@RequestMapping(value="manageTeacher/addTeacher",method = RequestMethod.POST)
	public ModelAndView addTeacher(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String count = request.getParameter("teacherCount");
		String password = request.getParameter("teacherPassword");
		if(count==null||password==null||count.equals("")||password.equals("")){
			model.setViewName("admin/manageTeacher/addTeacherFailed");
			return model;
		}
		TeacherWithBLOBs teacher = new TeacherWithBLOBs();
		teacher.setCount(count);
		teacher.setPassword(password);
		teacherService.addTeacherCount(teacher);
		model.setViewName("admin/manageTeacher/addTeacherSuccess");
		return model;
	}
	
	@RequestMapping(value="manageStudent")
	public ModelAndView manageStudent(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/manageStudent");
		List<Student> studentList = studentService.findAllStudent();
		model.addObject("studentList", studentList);
		return model;
	}
	
	@RequestMapping(value="manageExam")
	public ModelAndView manageExam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/manageExam");
		List<TestPaper> allExam = examService.findAllExam();
		model.addObject("examList", allExam);
		return model;
	}
	
	
	
}

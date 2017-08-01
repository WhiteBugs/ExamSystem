package com.gdut.ExamSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.service.AdminService;
import com.gdut.ExamSystem.service.StudentService;
import com.gdut.ExamSystem.service.TeacherService;


@Controller
@RequestMapping(value="/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @Resource(name="StudentService")
    private StudentService studentService;
    
    @Resource(name="AdminService")
    private AdminService adminService;
    
    @Resource(name="TeacherService")
    private TeacherService teacherService;
    

	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public ModelAndView checkAccount( HttpServletRequest request, HttpServletResponse response){
		
		if(request.getSession().getAttribute("user")!=null){
			request.getSession().removeAttribute("user");
		}
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String countType = request.getParameter("countType");
		logger.debug("进入loginController");
		switch (countType) {
		   case "admin":
				Adminstrator admin = adminService.findAdminByCount(userName);
				if(admin==null){
					return new ModelAndView("redirect:../login/wrongAccount");
				}
				if(!admin.getPassword().equals(userPassword)){
					return new ModelAndView("redirect:../login/wrongPassword");
				}
				request.getSession().setAttribute("user", admin);
				ModelAndView model = new ModelAndView("redirect:../admin/welcome");
				return model;
			   
		   case "student":
			   long studentID = Long.parseLong(userName);
			   logger.debug("学号为"+studentID);
			   Student student=studentService.findStudentByStudentID(studentID);
			   if(student==null){
				   return new ModelAndView("redirect:wrongAccount");
			   }
			   if(!userPassword.equals(student.getPassword())){
				   return new ModelAndView("redirect:wrongPassword");
			   }
			   request.getSession().setAttribute("user", student);
			   return new ModelAndView("redirect:../student/welcome");
			   
		   case "teacher":
			   Teacher teacher = teacherService.findTeacherByCount(userName);
			   if(teacher==null){
				   return new ModelAndView("redirect:wrongAccount");
			   }
			   if(!userPassword.equals(teacher.getPassword())){
				   return new ModelAndView("redirect:wrongPassword");
			   }
			   request.getSession().setAttribute("user", teacher);
			   return new ModelAndView("redirect:../teacher/welcome");
			   
		   default:
			   break;
		}
		return new ModelAndView("redirect:loginFailed");
	}
	
	@RequestMapping(value="login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		if(request.getSession().getAttribute("user")!=null){
			return hadLogin(request, response);
		}
		System.out.println("-------------------进入login");
		return new ModelAndView("/login/login");
	}
	
	@RequestMapping(value="hadLogin")
	public ModelAndView hadLogin(HttpServletRequest request, HttpServletResponse response){
		System.out.println("----------------------enter  hadLogin----------");
		ModelAndView model = new ModelAndView("/login/hadLogin");
		Object user = request.getSession().getAttribute("user");
		String type="";
		if(user instanceof Teacher){
			type="teacher";
			System.out.println("----------------------enter  TEA----------");
			model.addObject("type", type);
		}else if(user instanceof Student){
			type="student";
			System.out.println("----------------------enter  STU----------");
			model.addObject("type",type);
		}else if(user instanceof Adminstrator){
			type="admin";
			System.out.println("----------------------enter  ADM----------");
			model.addObject("type", type);
		}
		type="";
		return model;
	}
	
	
	@RequestMapping(value="/wrongAccount")
	public ModelAndView wrongAccount(){
		return new ModelAndView("login/wrongAccount");
	}
	
	@RequestMapping(value="/wrongPassword")
	public ModelAndView wrongPassword(){
		return new ModelAndView("login/wrongPassword");
	}
	
	@RequestMapping(value="/loginFailed",method=RequestMethod.GET)
	public ModelAndView loginFailed(){
		return new ModelAndView("login/loginFailed");
	}
	
	
	@RequestMapping(value="/loginOut", method = RequestMethod.GET)
	public ModelAndView loginOut(HttpServletRequest request , HttpServletResponse response){
		request.getSession().removeAttribute("user");
		ModelAndView model = new ModelAndView("redirect:/login/login");
		return model;
	}
	
	@RequestMapping(value="/cannotAccess")
	public ModelAndView CannotAccess(){
		return new ModelAndView("login/cannotAccess");
	}
}

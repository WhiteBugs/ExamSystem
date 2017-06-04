package com.gdut.ExamSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    

	@RequestMapping(value="/LoginCheck", method=RequestMethod.POST)
	public ModelAndView checkAccount(
		   @RequestParam (value="user_name") String userName,
           @RequestParam(value="user_password") String userPassword,
           @RequestParam(value="select_count") String countType,
           HttpServletRequest request, 
           HttpServletResponse response){
		
		System.out.println(userName+userPassword+countType);
		logger.debug("进入loginController");
		switch (countType) {  
		   case "admin":
			   Adminstrator adminstrator=adminService.findAdminByCount(userName);
			   if(adminstrator!=null){
				   return new ModelAndView("admin");
			   }
			   break;
		   case "student":
			   long studentID = Long.parseLong(userName);
			   logger.debug("学号为"+studentID);
			   Student student=studentService.findStudentByStudentID(studentID);
			   if(student!=null){
				   logger.debug("搜索到"+student.getName());
				   if(userPassword.equals(student.getPassword())){
					   ModelAndView model = new ModelAndView("redirect:../studentWelcome");
					   request.getSession().setAttribute("user", student);
					   return model;
				   }
			   }
			   break;
			   
		   case "teacher":
			   Teacher teacher = teacherService.findTeacherByCount(userName);
			   if(teacher!=null){
				   return new ModelAndView("teacher");
			   }
			   break;
		   default:
			   break;
		}
		return new ModelAndView("redirect:loginFailed");
	}
	
	@RequestMapping(value="/loginFailed",method=RequestMethod.GET)
	public ModelAndView loginFailed(){
		return new ModelAndView("login/loginFailed");
	}
	
	
	@RequestMapping(value="/loginOut", method = RequestMethod.GET)
	public ModelAndView loginOut(HttpServletRequest request , HttpServletResponse response){
		ModelAndView model = new ModelAndView("redirect:../login.jsp");
		request.getSession().removeAttribute("user");
		return model;
	}
}

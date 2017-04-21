package com.gdut.ExamSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.service.AdminService;
import com.gdut.ExamSystem.service.StudentService;
import com.gdut.ExamSystem.service.TeacherService;



@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @Resource(name="StudentService")
    private StudentService studentService;
    
    @Resource(name="AdminService")
    private AdminService adminService;
    
    @Resource(name="TeacherService")
    private TeacherService teacherService;
    

	@RequestMapping(value="/LoginCheck", method=RequestMethod.POST)
	public String checkAccount(
		   @RequestParam (value="user_name") String userName,
           @RequestParam(value="user_password") String userPassword,
           @RequestParam(value="select_count") String countType){
		
		System.out.println(userName+userPassword+countType);
		logger.debug("进入loginController");
		switch (countType) {
		   case "admin":
			   Adminstrator adminstrator=adminService.findAdminByCount(userName);
			   if(adminstrator!=null){
				   return "login/admin";
			   }
               return "login/loginFailed";
			   
		   case "student":
			   long studentID = Long.parseLong(userName);
			   logger.debug("学号为"+studentID);
			   Student student=studentService.findStudentByStudentID(studentID);
			   if(student!=null){
				   return "login/student";
			   }
			   return "login/loginFailed";
			   
		   case "teacher":
			   Teacher teacher = teacherService.findTeacherByCount(userName);
			   if(teacher!=null){
				   return "login/teacher";
			   }
			   return "login/loginFailed";
		   default:
			   break;
		}
		return "login/loginFailed";
	}
}

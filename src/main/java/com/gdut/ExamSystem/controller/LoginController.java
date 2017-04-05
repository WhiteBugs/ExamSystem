package com.gdut.ExamSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.gdut.ExamSystem.service.AdminService;
import com.gdut.ExamSystem.service.StudentService;
import com.gdut.ExamSystem.service.TeacherService;
import com.gdut.ExamSystem.service.base.BaseService;



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
			   if(Search(userName,userPassword,adminService)==0){
				   return "login/admin";
			   }
               return "login/loginFailed";
			   
		   case "student":
			   logger.info("跳转到学生选择");
			   if(Search(userName,userPassword,studentService)==0){
				   return "login/student";
			   }
			   return "login/loginFailed";
			   
		   case "teacher":
			   if(Search(userName,userPassword,teacherService)==0){
				   return "login/teacher";
			   }
			   return "login/loginFailed";
		   default:
			   break;
		}
		return "login/loginFailed";
	}
	
	private int Search(String userName,String userPassword,BaseService service){
	    int returnId = service.search(userName,userPassword);
		if(returnId==0){
			return 0;
		}else if(returnId==-1){
			System.out.print("账号错误");
		}else if(returnId==-2){
			System.out.print("密码错误");
		}
		return -1;
	}
	
}

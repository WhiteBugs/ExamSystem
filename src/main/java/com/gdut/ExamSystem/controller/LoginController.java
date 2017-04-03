package com.gdut.ExamSystem.controller;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdut.ExamSystem.service.AdminService;
import com.gdut.ExamSystem.service.StudentService;
import com.gdut.ExamSystem.service.TeacherService;
import com.gdut.ExamSystem.service.base.BaseService;



@Controller
public class LoginController {
	
    @Resource(name="StudentServiceImp")
    private StudentService studentService;
    
    @Resource(name="AdminServiceImp")
    private AdminService adminService;
    
    @Resource(name="TeacherServiecImp")
    private TeacherService teacherService;
    

	@RequestMapping("/LoginCheck")
	public String checkAccount(
		   @RequestParam (value="user_name") String userName,
           @RequestParam(value="user_password") String userPassword,
           @RequestParam(value="select_count") String countType){
		switch (countType) {
		   case "管理员":
			   if(Search(userName,userPassword,adminService)==0){
				   return "login/admin";
			   }
               return "login/loginFailed";
			   
		   case "学生":
			   if(Search(userName,userPassword,studentService)==0){
				   return "login/student";
			   }
			   return "login/loginFailed";
			   
		   case "监考老师":
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

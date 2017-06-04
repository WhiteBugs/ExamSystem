package com.gdut.ExamSystem.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.Student;

@Controller
public class WelcomeController {
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@RequestMapping(value="/studentWelcome",method=RequestMethod.GET)
	public ModelAndView studentWelcome(HttpServletRequest request , HttpServletResponse response){
		logger.debug("进入WelcomController的studentWelcome方法");
		ModelAndView model = new ModelAndView("login/studentWelcome");
		Student student = (Student)request.getSession().getAttribute("user");
		model.addObject("userName",student.getName());
		Cookie[] cookie = request.getCookies();
		request.getSession().getId();
		for(Cookie cookies : cookie){
			System.out.print(cookies);
		}
		return model;
	}
	
}

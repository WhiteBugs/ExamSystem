package com.gdut.ExamSystem.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@RequestMapping(value="/examSystem",method=RequestMethod.GET)
	public ModelAndView StudentWelcome(HttpServletRequest request , HttpServletResponse response){
		System.out.println("-----------------welcomeController-------------");
		if(request.getSession().getAttribute("user")==null){
			return new ModelAndView("redirect:login");
		}
		return new ModelAndView("redirect:login/havedLogin");
	}
	
}

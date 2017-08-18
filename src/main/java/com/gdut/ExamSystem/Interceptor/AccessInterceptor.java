package com.gdut.ExamSystem.Interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gdut.ExamSystem.model.Teacher;

public class AccessInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("user")==null){
			System.out.println("----------------------enter  prehandle  user  == null ----------");
			response.sendRedirect(request.getContextPath()+"/login/login");
			return false;
		}else if(request.getRequestURI().equals("/ExamSystem/")||request.getRequestURI().equals("/ExamSystem")){
			System.out.println("----------------------enter  prehandle----------"+request.getRequestURI());
			response.sendRedirect(request.getContextPath()+"/login/hadLogin");
			return false;
		}
		return true;
	}
}

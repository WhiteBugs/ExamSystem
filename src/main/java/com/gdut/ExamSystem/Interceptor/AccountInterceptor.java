package com.gdut.ExamSystem.Interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;

public class AccountInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI()+"?"+request.getQueryString();
		System.out.println("-------------"+url+"--------------");
		Object user = request.getSession().getAttribute("user");
		if(user instanceof Student&&(url.contains("/admin/")||url.contains("/teacher/"))){
			response.sendRedirect(request.getContextPath()+"/login/cannotAccess");
			return false;
		}
		if(user instanceof Teacher&&(url.contains("/admin/")||url.contains("/student/"))){
			response.sendRedirect(request.getContextPath()+"/login/cannotAccess");
			return false;
		}
		if(user instanceof Adminstrator&&(url.contains("/student/")||url.contains("/teacher/"))){
			response.sendRedirect(request.getContextPath()+"/login/cannotAccess");
			return false;
		}
		return true;
	}

}

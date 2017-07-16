package com.gdut.ExamSystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.ExamService;
import com.gdut.ExamSystem.service.TeacherService;


@Controller
@RequestMapping(value="teacher")
public class TeacherController {
	
	
	@Resource(name="ExamService")
	private ExamService examService;
	
	@Resource(name="TeacherService")
	private TeacherService teacherService;
	
	@RequestMapping(value="welcome")
	public ModelAndView TeacherWelcome(HttpServletRequest request){
		Teacher teacher = (Teacher)request.getSession().getAttribute("user");
		ModelAndView model = new ModelAndView();
		model.addObject("user", teacher);
		List<TestPaper> examList = examService.findAllExamByTeacherCount(teacher.getCount());
		model.addObject("examList", examList);
		model.setViewName("teacher/teacherWelcome");
		return model;
		
	}
	
	@RequestMapping(value="exam")
	public ModelAndView Exam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/exam/examList");
		Teacher teacher = (Teacher)request.getSession().getAttribute("user");
		List<TestPaper> examList = examService.findAllExamByTeacherCount(teacher.getCount());
		model.addObject("examList", examList);
		return model;
	}
	
	@RequestMapping(value="addTest")
	public ModelAndView addTest(HttpServletRequest request , HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/addTest");	
		return model;
	}
	
	@RequestMapping(value="addTest/submit")
	public ModelAndView submit(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException{
		ModelAndView model = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		switch (type) {
		case "choice":
			ChoiceQuestion question = new ChoiceQuestion();
			question.setTittle(request.getParameter("title"));
			question.setChoice1(request.getParameter("option1"));
			question.setChoice2(request.getParameter("option2"));
			question.setChoice3(request.getParameter("option3"));
			question.setChoice4(request.getParameter("option4"));
			question.setAnswer(request.getParameter("answer"));
			System.out.println("---------------------"+question.getTittle());
			teacherService.addChoiceQuestionIntoDB(question);
			model.setViewName("teacher/addTest/result/success");
			break;
		case "blankFilling":
			BlankFillingQuestion question2 =new BlankFillingQuestion();
			question2.setTittle(request.getParameter("title"));
			String[] answers = request.getParameter("answer").split("\\s+");
			for(String answer:answers){
				System.out.print("--"+answer+"---");
			}
			teacherService.addBlankFillingQuestionIntoDB(question2, answers);
			model.setViewName("teacher/addTest/result/success");
			break;
		case "eassy":
			EassyQuestion question3 = new EassyQuestion();
			question3.setTittle(request.getParameter("title"));
			question3.setAnswer(request.getParameter("answer"));
			teacherService.addEassyQuestionIntoDB(question3);
			model.setViewName("teacher/addTest/result/success");
			break;
		default:model.setViewName("teacher/addTest/result/failed");
			break;
		}
		return model;
	}
	
	@RequestMapping(value="addTest/loadPage")
	public ModelAndView loadPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		System.out.println("--------loadPage---------");
		String type = request.getParameter("type");
		switch (type) {
		case "choice":
			model.setViewName("teacher/addTest/loadPage/choice");
			break;
		case "blankFilling":
			model.setViewName("teacher/addTest/loadPage/blankFilling");
			break;
		case "eassy":
			model.setViewName("teacher/addTest/loadPage/eassy");
			break;
		default:model.setViewName("/ExamSystem/info/404");
			break;
		}
		return model;
	}
}

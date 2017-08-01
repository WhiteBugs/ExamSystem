package com.gdut.ExamSystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.ExamService;
import com.gdut.ExamSystem.service.TeacherService;

import oracle.jdbc.OracleConnection.CommitOption;
import oracle.net.aso.e;


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
	
	@RequestMapping(value="exam/editExam")
	public ModelAndView editExam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String md5 = request.getParameter("md5");
		if(md5 != null){
			//补上通过MD5查找试卷编号并查询相关试题的代码
		}
		if(true){
			List<ChoiceQuestion> choiceQuestions = examService.findAllChoiceQuestion();
			model.addObject("choiceQuestions", choiceQuestions);
			List<EassyQuestion> eassyQuestions = examService.findAllEassyQuestion();
			model.addObject("eassyQuestions", eassyQuestions);
			model.setViewName("/teacher/editTest/test/exam");
		}
		return model;
	}
	
	@RequestMapping(value="addTest")
	public ModelAndView addTest(HttpServletRequest request , HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/addTest");	
		return model;
	}
	
	@RequestMapping(value="editTest")
	public ModelAndView editTest(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("/teacher/editTest/noSuchTest");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		if(id!=null){
			model.setViewName("/teacher/editTest/editTest");
			switch (type) {
			case "choiceQuestion":
				model.addObject("choiceQuestion",teacherService.findChoiceQuestionById(Integer.parseInt(id)));
				break;
			case "MultipleChoiceQuestion":
				break;
			case "TFQuestion":
				break;
			case "blankFillingQuestion":
				model.addObject("blankFillingQuestion", teacherService.findBlankFillingQuestionById(Integer.parseInt(id)));
				break;
			case "eassyQuestion":
				model.addObject("eassyQuestion", teacherService.findEassyQuestionById(Integer.parseInt(id)));
				break;
			default:
				model.setViewName("/teacher/editTest/noSuchTest");
				System.out.println("---------type  is   null------------");
				break;
			}
		}else{
			System.out.println("-------------question  id  is  null-------------");
		}
		return model;
	}
	
	@RequestMapping(value="editTest/commit")
	public ModelAndView editTestCommit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("/teacher/editTest/alterSuccess");
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String choice1 = request.getParameter("choice1");
		String choice2 = request.getParameter("choice2");
		String choice3 = request.getParameter("choice3");
		String choice4 = request.getParameter("choice4");
		String answer = request.getParameter("answer");
		System.out.println("----"+id+"-----"+type+"------------"+title+"-----------");
		ChoiceQuestion choiceQuestion = new ChoiceQuestion();
		choiceQuestion.setAnswer(answer);
		choiceQuestion.setChoice1(choice1);
		choiceQuestion.setChoice2(choice2);
		choiceQuestion.setChoice3(choice3);
		choiceQuestion.setChoice4(choice4);
		choiceQuestion.setTitle(title);
		choiceQuestion.setChoiceQuestionId(Integer.parseInt(id));
		teacherService.updateChoiceQuestion(choiceQuestion);
		return model;
	}
	
	@RequestMapping(value="editTest/addEassyQuestion")
	public ModelAndView addEassyQuestion(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/editTest/addQuestion");
		List<EassyQuestion> eassyQuestions = examService.findAllEassyQuestion();
		model.addObject("eassyQuestions", eassyQuestions);
		return model;
	}
	@RequestMapping(value="editTest/addChoiceQuestion")
	public ModelAndView addChoiceQuestion(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/editTest/addQuestion");
		List<ChoiceQuestion> choiceQuestions = examService.findAllChoiceQuestion();
		model.addObject("choiceQuestions", choiceQuestions);
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
			question.setTitle(request.getParameter("title"));
			question.setChoice1(request.getParameter("option1"));
			question.setChoice2(request.getParameter("option2"));
			question.setChoice3(request.getParameter("option3"));
			question.setChoice4(request.getParameter("option4"));
			question.setAnswer(request.getParameter("answer"));
			System.out.println("---------------------"+question.getTitle());
			teacherService.addChoiceQuestionIntoDB(question);
			model.setViewName("teacher/addTest/result/success");
			break;
		case "blankFilling":
			BlankFillingQuestion question2 =new BlankFillingQuestion();
			question2.setTitle(request.getParameter("title"));
			String[] answers = request.getParameter("answer").split("\\s+");
			for(String answer:answers){
				System.out.print("--"+answer+"---");
			}
			teacherService.addBlankFillingQuestionIntoDB(question2, answers);
			model.setViewName("teacher/addTest/result/success");
			break;
		case "eassy":
			EassyQuestion question3 = new EassyQuestion();
			question3.setTitle(request.getParameter("title"));
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

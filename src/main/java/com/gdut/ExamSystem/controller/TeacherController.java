package com.gdut.ExamSystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gdut.ExamSystem.Util.GenerateHTML;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.BlankFillingQuestionWithAnswers;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.ChoiceQuestionJunction;
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
	
	@RequestMapping(value="exam/editExam")
	public ModelAndView editExam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String examId = request.getParameter("examId");
		if(examId != null){
			TestPaper exam = examService.findExamById(examId);
			model.addObject("exam", exam);
			List<ChoiceQuestion> choiceQuestions = examService.findChoiceQuestionOfExam(examId);
			if(choiceQuestions!=null&&choiceQuestions.size()>0){
				model.addObject("choiceQuestions", choiceQuestions);
			}
			List<BlankFillingQuestionWithAnswers> blankFillingQuestions = examService.findBlankFillingQuestionOfExam(examId);
			if(blankFillingQuestions!=null&&blankFillingQuestions.size()>0){
				model.addObject("blankFillingQuestions", blankFillingQuestions);
			}
			List<EassyQuestion> eassyQuestions = examService.findEassyQuestionOfExam(examId);
			if(eassyQuestions!=null&&eassyQuestions.size()>0){
				model.addObject("eassyQuestions", eassyQuestions);
			}
			
			model.setViewName("/teacher/editTest/exam/examTemplet");
			
		}
		return model;
	}
	
	@RequestMapping(value="exam/editExam/commit")
	public ModelAndView editExamCommit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String examId = request.getParameter("examId");
		if(examId == null){
			model.addObject("info", "没有得到试卷Id");
			return model;
		}else{
			Map<Object, Object> models = new HashMap<>();
			TestPaper exam = examService.findExamById(examId);
			models.put("exam", exam);
			List<ChoiceQuestion> choiceQuestions = examService.findChoiceQuestionOfExam(examId);
			if(choiceQuestions!=null&&choiceQuestions.size()>0){
				models.put("choiceQuestions", choiceQuestions);
			}
			List<BlankFillingQuestionWithAnswers> blankFillingQuestions = examService.findBlankFillingQuestionOfExam(examId);
			if(blankFillingQuestions!=null&&blankFillingQuestions.size()>0){
				models.put("blankFillingQuestions", blankFillingQuestions);
			}
			List<EassyQuestion> eassyQuestions = examService.findEassyQuestionOfExam(examId);
			if(eassyQuestions!=null&&eassyQuestions.size()>0){
				models.put("eassyQuestions", eassyQuestions);
			}
			try{
				GenerateHTML.generateExamHTML(request, models);
				model.addObject("info", "生成成功");
			}catch (Exception e) {
				model.addObject("info", "生成失败");
			}
		}
		return model;
	}
	
	
	@RequestMapping(value="addQuestion(HttpServletRequest, HttpServletResponse)")
	public ModelAndView addQuestion(HttpServletRequest request , HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/addTest");	
		return model;
	}
	
	@RequestMapping(value="editQuestion")
	public ModelAndView editQuestion(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		if(id!=null){
			model.setViewName("/teacher/editTest/editQuestion");
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
				model.setViewName("teacher/info");
				model.addObject("info", "no such question");
				System.out.println("---------type  is   null------------");
				break;
			}
		}else{
			model.addObject("info", "no such question");
			System.out.println("-------------question  id  is  null-------------");
		}
		return model;
	}
	
	@RequestMapping(value="editQuestion/commit")
	public ModelAndView editQuestionCommit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/info");
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
		model.addObject("info", "修改成功");
		return model;
	}
	
	@RequestMapping(value="editQuestion/addQuestion")
	public ModelAndView addQuestionIntoExam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/editTest/addQuestion");
		String type = request.getParameter("type");
		String examId = request.getParameter("examId");
		if(examId==null){
			model.setViewName("teacher/info");
			model.addObject("info", "找不到考试ID");
			return model;
		}
		model.addObject("examId", examId);
		switch (type) {
		case "choiceQuestion":
			List<ChoiceQuestion> choiceQuestions = examService.findAllChoiceQuestion();
			List<ChoiceQuestion> choiceQuestionOfExam = examService.findChoiceQuestionOfExam(examId);
			for(int i=0;i<choiceQuestionOfExam.size();i++){
				for(int j=0;j<choiceQuestions.size();j++){
					if(choiceQuestionOfExam.get(i).getChoiceQuestionId()==choiceQuestions.get(j).getChoiceQuestionId()){
						choiceQuestions.remove(j);
					}
					if(j==choiceQuestions.size()){
						break;
					}
				}
			}
			model.addObject("choiceQuestions", choiceQuestions);
			break;
		case "multipleChoiceQuestion":
			
			break;
		case "blankFillingQuestion":
			List<BlankFillingQuestionWithAnswers> blankFillingQuestions = examService.findAllBlankFillingQuestion();
			model.addObject("blankFillingQuestions", blankFillingQuestions);
			break;
		case "trueFalseQuestion":
			
			break;
		case "eassyQuestion":
			List<EassyQuestion> eassyQuestions = examService.findAllEassyQuestion();
			model.addObject("eassyQuestions", eassyQuestions);
			break;

		default:
			break;
		}
		return model;
	}
	
	@RequestMapping(value="editQuestion/addQuestion/commit")
	public ModelAndView addQuestionIntoExamCommit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String type = request.getParameter("type");
		String examId = request.getParameter("examId");
		String[] ids = request.getParameterValues("id");
		if(ids==null||ids.length==0){
			model.setViewName("teacher/info");
			model.addObject("info", "没有选择试题，请返回上一页<a href=\"/ExamSystem/teacher/editTest/addQuestion?type=choiceQuestion\">链接</a>");
			return model;
		}
		if(examId==null){
			model.setViewName("teacher/info");
			model.addObject("info", "没有获得试卷ID<a href=\"/ExamSystem/teacher/editTest/addQuestion?type=choiceQuestion\">链接</a>");
			return model;
		}
		int order = 0;
		switch (type){
		case "choiceQuestion":
			order = examService.findChoiceQuestionOfExam(examId).size();
			for(int i=1;i<ids.length+1;i++){
				 teacherService.addChoiceQuestionOfExam(examId, Integer.parseInt(ids[i-1]), i+order);
			}
			order = 0;
			model.addObject("info", "添加选择题成功");
			break;
		case "multipleChoiceQuestion":
			model.addObject("info", "添加多选题成功");
			break;
		case "blankFillingQuestion":
			order = examService.findBlankFillingQuestionOfExam(examId).size();
			for(int i=1;i<ids.length+1;i++){
				teacherService.addBlankFillingQuestionOfExam(examId, Integer.parseInt(ids[i-1]), i+order);
			}
			order = 0;
			model.addObject("info", "添加填空题成功");
			break;
		case "trueFalseQuestion":
			model.addObject("info", "添加判断题成功");
			break;
		case "eassyQuestion":
			order = examService.findEassyQuestionOfExam(examId).size();
			for(int i=1;i<ids.length+1;i++){
				teacherService.addEassyQuestionOfExam(examId, Integer.parseInt(ids[i-1]), i+order);
			}
			order = 0;
			model.addObject("info", "添加简答题成功");
			break;

		default:
			model.addObject("info", "addQuestionIntoExam>>不是已有的题型");
			break;
		}
		return model;
	}
	
	@RequestMapping(value="addQuestion/submit")
	public ModelAndView addQuestionubmit(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException{
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

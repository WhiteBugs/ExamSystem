package com.gdut.ExamSystem.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gdut.ExamSystem.Util.Generate;
import com.gdut.ExamSystem.enums.QuestionType;
import com.gdut.ExamSystem.model.BlankFillingQuestion;
import com.gdut.ExamSystem.model.BlankFillingQuestionWithAnswers;
import com.gdut.ExamSystem.model.ChoiceQuestion;
import com.gdut.ExamSystem.model.EassyQuestion;
import com.gdut.ExamSystem.model.ExamInfo;
import com.gdut.ExamSystem.model.Question;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.ExamService;
import com.gdut.ExamSystem.service.StudentService;
import com.gdut.ExamSystem.service.TeacherService;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;



@Controller
@RequestMapping(value="teacher")
public class TeacherController {
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@Resource(name="ExamService")
	private ExamService examService;
	
	@Resource(name="StudentService")
	private StudentService studentService;
	
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
	public ModelAndView ExamList(HttpServletRequest request, HttpServletResponse response){
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
			model.addObject("time", exam.getExamTime().toString());
			model.setViewName("/teacher/editExam/exam/examTemplet");
			
		}
		return model;
	}
	
	@RequestMapping(value="exam/editExam/commit")
	public ModelAndView editExamCommit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String examId = request.getParameter("examId");
		String choiceScore = request.getParameter("choiceScore");
		String multipleScore = request.getParameter("multipleScore");
		String tfScore = request.getParameter("tfScore");
		String blankScore = request.getParameter("blankScore");
		String eassyScore = request.getParameter("eassyScore");
		if(examId == null){
			model.addObject("info", "没有得到试卷Id");
			return model;
		}else{
			Map<Object, Object> models = new HashMap<>();
			TestPaper exam = examService.findExamById(examId);
			String examName = exam.getExamName();
			ExamInfo examInfo = new ExamInfo();
			examInfo.setExamName(examName);
			examInfo.setTestPaperExamId(examId);
			
			models.put("exam", exam);
			if(choiceScore != null){
				models.put("choiceScore", Integer.parseInt(choiceScore));
				examInfo.setQuestionType(QuestionType.choiceQuestion.toString());
				examInfo.setScore(Integer.parseInt(choiceScore));
				examService.addQuestionScore(examInfo);
			}
			if(multipleScore != null){
				models.put("multipleScore", Integer.parseInt(multipleScore));
				examInfo.setQuestionType(QuestionType.multipleChoiceQuestion.toString());
				examInfo.setScore(Integer.parseInt(multipleScore));
				examService.addQuestionScore(examInfo);
			}
			if(tfScore != null){
				models.put("tfScore", Integer.parseInt(tfScore));
				examInfo.setQuestionType(QuestionType.trueFalseQuestion.toString());
				examInfo.setScore(Integer.parseInt(tfScore));
				examService.addQuestionScore(examInfo);
			}
			if(blankScore != null){
				models.put("blankScore", Integer.parseInt(blankScore));
				examInfo.setQuestionType(QuestionType.blankFillingQuestion.toString());
				examInfo.setScore(Integer.parseInt(blankScore));
				examService.addQuestionScore(examInfo);
			}
			if(eassyScore != null){
				models.put("eassyScore", Integer.parseInt(eassyScore));
				examInfo.setQuestionType(QuestionType.eassyQuestion.toString());
				examInfo.setScore(Integer.parseInt(eassyScore));
				examService.addQuestionScore(examInfo);
			}
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
			models.put("time", exam.getExamTime().toString());
			try{
				Generate.generateExamHTML(request, models);
				model.addObject("info", "生成试卷成功");
			}catch (Exception e) {
				model.addObject("info", "生成试卷失败");
			}
			try{
				generateExamAnswer(request, examId);
			}catch (Exception e) {
				logger.error("------------生成答案失败--------");
				e.printStackTrace();
			}
		}
		return model;
	}
	
	@RequestMapping(value="exam/studentExamList")
	public ModelAndView studentExamList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String examId = request.getParameter("examId");
		if(examId == null){
			model.addObject("info", "没有获得examId");
			return model;
		}
		model.setViewName("teacher/exam/editStudentExam");
		List<Long> studentIds = examService.findAllStudentIdByExamId(examId);
		List<Student> students = new ArrayList<Student>();
		for(long studentId : studentIds){
			students.add(studentService.findStudentByStudentID(studentId));
		}
		model.addObject("students", students);
		model.addObject("examId", examId);
		return model;
	}
	
	@RequestMapping(value="exam/editStudentExam")
	public ModelAndView editStudentExam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String studentId = request.getParameter("studentId");
		String examId = request.getParameter("examId");
		if(true||studentId == null || examId == null){
			model.addObject("info", "只写了单选题部分，其他还没写    位置 teacherController---》editStudentExam");
			return  model;
		}
		model.setViewName("teacher/exam/studentExamTemplate");
		model.addObject("student", studentService.findStudentByStudentID(Long.parseLong(studentId)));
		model.addObject("choiceQuestions", examService.findQuestionWithStudentAnswer(examId, studentId, QuestionType.choiceQuestion));
		model.addObject("choiceScore", examService.findQuestionScoreOfExam(examId, QuestionType.choiceQuestion.toString()).getScore());
		
		
		return model;
	}
	
	@RequestMapping(value="exam/answer")
	public ModelAndView answer (HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String examId = request.getParameter("examId");
		if(examId == null){
			model.addObject("info", "没有获得examId");
			return model;
		}
		File answer = new File(request.getSession().getServletContext().getRealPath("/")+"WEB-INF/view/exam/"+examId+"/answer.html");
		if(!answer.exists()){
			model.addObject("info", "还没有生成答案，请先于试卷编辑页面按下生成按钮同时生成试卷和答案");
			return model;
		}else {
			model.setViewName("exam/"+examId+"/answer");
		}
		return model;
	}
 	
	@RequestMapping(value="addQuestion")
	public ModelAndView addQuestion(HttpServletRequest request , HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/addQuestion");	
		return model;
	}
	
	@RequestMapping(value="editQuestion")
	public ModelAndView editQuestion(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("teacher/info");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		if(id!=null){
			model.setViewName("/teacher/editExam/editQuestion");
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
		ModelAndView model = new ModelAndView("teacher/editExam/addQuestion");
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
			model.addObject("info", "没有选择试题，请返回上一页<a href=\"/ExamSystem/teacher/editExam/addQuestion?type=choiceQuestion\">链接</a>");
			return model;
		}
		if(examId==null){
			model.setViewName("teacher/info");
			model.addObject("info", "没有获得试卷ID<a href=\"/ExamSystem/teacher/editExam/addQuestion?type=choiceQuestion\">链接</a>");
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
			model.setViewName("teacher/addQuestion/result/success");
			break;
		case "blankFilling":
			BlankFillingQuestion question2 =new BlankFillingQuestion();
			question2.setTitle(request.getParameter("title"));
			String[] answers = request.getParameter("answer").split("\\s+");
			for(String answer:answers){
				System.out.print("--"+answer+"---");
			}
			teacherService.addBlankFillingQuestionIntoDB(question2, answers);
			model.setViewName("teacher/addQuestion/result/success");
			break;
		case "eassy":
			EassyQuestion question3 = new EassyQuestion();
			question3.setTitle(request.getParameter("title"));
			question3.setAnswer(request.getParameter("answer"));
			teacherService.addEassyQuestionIntoDB(question3);
			model.setViewName("teacher/addQuestion/result/success");
			break;
		default:model.setViewName("teacher/addQuestion/result/failed");
			break;
		}
		return model;
	}
	
	@RequestMapping(value="addQuestion/loadPage")
	public ModelAndView loadPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		System.out.println("--------loadPage---------");
		String type = request.getParameter("type");
		switch (type) {
		case "choice":
			model.setViewName("teacher/addQuestion/loadPage/choice");
			break;
		case "blankFilling":
			model.setViewName("teacher/addQuestion/loadPage/blankFilling");
			break;
		case "eassy":
			model.setViewName("teacher/addQuestion/loadPage/eassy");
			break;
		default:model.setViewName("/ExamSystem/info/404");
			break;
		}
		return model;
	}
	
	private int generateExamAnswer(HttpServletRequest request, String examId) {
		String path = request.getSession().getServletContext().getRealPath("/")+"WEB-INF/view/exam/"+examId;
		File dir = new File(path);
		 if(!dir.exists()){
			 dir.mkdirs();
		 }
		 File file = new File(path,"answer.html");
		 if(!file.exists()){
			 try {
				file.createNewFile();
			} catch (IOException e) {
				logger.error("-------------创建answer.html失败-----------");
				e.printStackTrace();
				return -1;
			}
		 }
		 FileWriter writer = null;
		 try {
			writer = new FileWriter(file);
		 } catch (IOException e) {
			e.printStackTrace();
			return -1;
		 } 
		 TestPaper exam = examService.findExamById(examId);
		 Map<Integer, String> choiceQuestionAnswers = examService.findQuestionAnswer(examId, QuestionType.choiceQuestion);
		 Map<Integer, String> multipleQuestionAnswers = examService.findQuestionAnswer(examId, QuestionType.multipleChoiceQuestion);
		 Map<Integer, String> trueFalseQuestionAnswers = examService.findQuestionAnswer(examId, QuestionType.trueFalseQuestion);
		 Map<Integer, String> blankQuestionAnswers = examService.findQuestionAnswer(examId, QuestionType.blankFillingQuestion);
		 Map<Integer, String> eassyQuestionAnswers = examService.findQuestionAnswer(examId, QuestionType.eassyQuestion);
		 Map<String , Object> dataModel = new HashMap<>();
		 dataModel.put("choiceQuestionAnswers", choiceQuestionAnswers);
		 dataModel.put("multipleQuestionAnswers", multipleQuestionAnswers);
		 dataModel.put("trueFalseQuestionAnswers", trueFalseQuestionAnswers);
		 dataModel.put("blankQuestionAnswers", blankQuestionAnswers);
		 dataModel.put("eassyQuestionAnswers", eassyQuestionAnswers);
		 dataModel.put("exam", exam);
		 Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		 configuration.setServletContextForTemplateLoading(request.getSession().getServletContext(), "WEB-INF/view/freemarker/exam/");
		 try {
			Template template = configuration.getTemplate("answerTemplet.ftl");
			template.process(dataModel, writer);
		} catch (TemplateNotFoundException e) {
			logger.error("----------没有找到模板");
			e.printStackTrace();
			return -1;
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (ParseException e) {
			logger.error("------------模板转换错误-----------");
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			logger.error("-------------IOException--------------");
			e.printStackTrace();
			return -1;
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		 return 0;
	}
}

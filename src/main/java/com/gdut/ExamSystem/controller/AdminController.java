package com.gdut.ExamSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gdut.ExamSystem.Util.GenerateMD5;
import com.gdut.ExamSystem.model.Adminstrator;
import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.model.Teacher;
import com.gdut.ExamSystem.model.TeacherWithBLOBs;
import com.gdut.ExamSystem.model.TestPaper;
import com.gdut.ExamSystem.service.AdminService;
import com.gdut.ExamSystem.service.ExamService;
import com.gdut.ExamSystem.service.StudentService;
import com.gdut.ExamSystem.service.TeacherService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;



@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Resource(name="ExamService")
	private ExamService examService;
	
	@Resource(name="AdminService")
	private AdminService adminService;
	
	@Resource(name="TeacherService")
	private TeacherService teacherService;
	
	@Resource(name="StudentService")
	private StudentService studentService;
	
	
	@RequestMapping(value="welcome")
	public ModelAndView adminWelcome(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/adminWelcome");
		Adminstrator admin = (Adminstrator)request.getSession().getAttribute("user");
		model.addObject("user", admin);
		return model;
	}
	
	
	@RequestMapping(value="addExam")
	public ModelAndView addExam(HttpServletRequest requests, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/addExam");
		model.addObject("teachers", teacherService.findAllTeacher());
		model.addObject("majors", studentService.findAllMajor());
		return model;
	}
	
	@RequestMapping(value="addExam/studentType")
	public ModelAndView studentType(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String studentType = request.getParameter("studentType");
		if(studentType!=null){
			switch (studentType) {
			case "major":
				model.addObject("majors", studentService.findAllMajor());
				model.setViewName("admin/addExam/addStudent/major");
				break;
			case "class":
				model.addObject("majors", studentService.findAllMajor());
				model.setViewName("admin/addExam/addStudent/class");
				break; 
			case "person":
				model.addObject("majors", studentService.findAllMajor());
				model.setViewName("admin/addExam/addStudent/person");
				break;
			default:
				break;
			}
		}
		return model;
	}
	@RequestMapping(value="addExam/studentType/class")
	public ModelAndView typeOfClass(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String major = request.getParameter("major");
		if(major!=null){
			System.out.println("--------------"+major);
			model.addObject("classes",studentService.findClassesByMajor(major));
			model.setViewName("admin/addExam/addStudent/classOfMajor");
		}else{
			model.setViewName("admin/addExam/addStudent/blank");
		}
		return model;
	}
	@RequestMapping(value="addExam/studentType/person")
	public ModelAndView person(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String major = request.getParameter("major");
		String classs = request.getParameter("class");
		if(major!=null && classs!=null){
			System.out.println("--------------------------进入person");
			model.addObject("persons", studentService.findStudentByMajorAndClasses(major, Integer.parseInt(classs)));
			model.setViewName("admin/addExam/addStudent/personSelection");
		}else{
			model.setViewName("admin/addExam/addStudent/blank");
		}
		return model;
	}
	
	@RequestMapping(value="addExam/commit",method=RequestMethod.POST)
	public ModelAndView commit(HttpServletRequest request, HttpServletResponse response) throws ParseException, MySQLIntegrityConstraintViolationException{
		ModelAndView model = new ModelAndView();
		String[] students = request.getParameterValues("student");
		String[] majors = request.getParameterValues("major");
		String classs = request.getParameter("class");
 		ArrayList<Student> studentList = new ArrayList<>();
 		if(majors!=null){
 			if(classs!=null){
 				if(students!=null){
 					for(String studentId : students){
 						studentList.add(studentService.findStudentByStudentID(Long.parseLong(studentId)));
 					}
 				}else {
 					studentList = studentService.findStudentByMajorAndClasses(majors[0], Integer.parseInt(classs));
				}
 			}else{
 				studentList = studentService.findStudentByMajor(majors);
 			}
 		}
		String[] teacher = request.getParameterValues("teachers");
		String examName = request.getParameter("examName");
		String date = request.getParameter("date");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		TestPaper exam = new TestPaper();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date begin = time.parse(date+" "+beginTime);
		Date end = time.parse(date+" "+endTime);
        List<String> counts = new ArrayList<>();
        for(String teachs : teacher){
        	counts.add(teachs);
        }
		StringBuilder md5Torrent = new StringBuilder();
		//用考试名称，日期生成摘要作为ID
		md5Torrent.append(examName);
		md5Torrent.append(date);
		md5Torrent.append(beginTime);
		md5Torrent.append(endTime);
		String examId = GenerateMD5.getMD5(md5Torrent.toString());
		
		if(examService.findExamById(examId)==null){
			exam.setExamId(examId);
			exam.setBeginTime(begin);
			exam.setEndTime(end);
			exam.setExamName(examName);
			examService.addExam(exam);
			adminService.addTeacher(examId, counts);
			for(Student student : studentList){
				examService.addStudentOfExam(examId, student.getStudentId());
			}
			model.addObject("info", "添加成功");
			model.setViewName("admin/info");
		}else{
			model.addObject("info", "已经添加过同样的考试了");
			model.setViewName("admin/info");
		}
		return model;
	}
	
	@RequestMapping(value="manageTeacher")
	public ModelAndView manageTeacher(HttpServletRequest requests, HttpServletResponse response){
		List<Teacher> teacherList = teacherService.findAllTeacher();
		ModelAndView model = new ModelAndView("admin/manageTeacher");
		model.addObject("teacherList", teacherList);
		return model;
 	}
	
	@RequestMapping(value="manageTeacher/addTeacher",method = RequestMethod.POST)
	public ModelAndView addTeacher(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		String count = request.getParameter("teacherCount");
		String password = request.getParameter("teacherPassword");
		if(count==null||password==null||count.equals("")||password.equals("")){
			model.setViewName("admin/manageTeacher/addTeacherFailed");
			return model;
		}
		TeacherWithBLOBs teacher = new TeacherWithBLOBs();
		teacher.setCount(count);
		teacher.setPassword(password);
		teacherService.addTeacherCount(teacher);
		model.setViewName("admin/manageTeacher/addTeacherSuccess");
		return model;
	}
	
	@RequestMapping(value="manageStudent")
	public ModelAndView manageStudent(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/manageStudent");
		List<Student> studentList = studentService.findAllStudent();
		model.addObject("studentList", studentList);
		return model;
	}
	
	@RequestMapping(value="manageExam")
	public ModelAndView manageExam(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("admin/manageExam");
		List<TestPaper> allExam = examService.findAllExam();
		model.addObject("examList", allExam);
		return model;
	}
	
	
	
}

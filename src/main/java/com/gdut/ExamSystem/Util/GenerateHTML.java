package com.gdut.ExamSystem.Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.gdut.ExamSystem.model.TestPaper;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class GenerateHTML {
	
	
	public static int  generateExamHTML(HttpServletRequest request, Map model){
		FileWriter out = null;
		try {
		    // 通过FreeMarker的Configuration读取相应的模板文件
		    Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
		    // 设置模板路径
		    configuration.setServletContextForTemplateLoading(request.getSession().getServletContext(), "WEB-INF/view/freemarker/exam/");
		    // 设置默认字体
		     configuration.setDefaultEncoding("utf-8");
		    // 获取模板
		    Template template = configuration.getTemplate("examTemplet.ftl");
		    TestPaper exam =  (TestPaper) model.get("exam");
		    //设置模型
		    File path = new File(request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/view/exam/"+exam.getExamId());
		    File file = new File(path,exam.getExamId()+".html");
		    if(!path.exists()) {	    	
		    	path.mkdirs();
			   } 
		    if(!file.exists()){
		    	file.createNewFile();
		    }
		    out = new FileWriter(file);
		    //模板输出静态文件
		    template.process(model, out);
		    } catch (TemplateNotFoundException e) {
			    e.printStackTrace();
		    } catch (MalformedTemplateNameException e) {
			    e.printStackTrace();
			} catch (ParseException e) {
			    e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
		        e.printStackTrace();
		        } finally {
		             if(null != out) {
		                 try {
		                     out.close();
		                 } catch (IOException e) {
		                     e.printStackTrace();
		                 }
		             }
		         }
	
		return 0;
	}

}

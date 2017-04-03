package com.gdut.ExamSystem.model;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

public class Student {
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    public String login() throws Exception{
    	
    	return "";
    }
}
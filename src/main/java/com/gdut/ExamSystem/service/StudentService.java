package com.gdut.ExamSystem.service;

import com.gdut.ExamSystem.model.Student;
import com.gdut.ExamSystem.service.base.BaseService;

public interface StudentService extends BaseService {
     public void add(Student student);
     public void delete(Student student);
     public Student findStudent();
     public void changeStudentByName();
}

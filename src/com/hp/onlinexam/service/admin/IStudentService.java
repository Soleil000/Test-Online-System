package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;

public interface IStudentService { 
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public Map<String,Object> findStudentById(int id);
	public List<Map<String,Object>> findAll();
	public List<Map<String,Object>> findAllByName(String name);
	public void deleteStudentById(int id);
}

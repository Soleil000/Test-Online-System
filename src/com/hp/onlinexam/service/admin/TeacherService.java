package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.ITeacherDao;
import com.hp.onlinexam.dao.admin.TeacherDao;
import com.hp.onlinexam.po.Teacher;

public class TeacherService implements ITeacherService{
	private ITeacherDao td = new TeacherDao(); 
	@Override
	public List<Teacher> findTeachers(String name) {
		// TODO Auto-generated method stub
		return td.findAllTeacherByInfo(name);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		td.addTeacher(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		// TODO Auto-generated method stub
		td.updateTeacher(teacher, oldid);
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return td.findTeacherInfo(id);
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherById(int id) {
		// TODO Auto-generated method stub
		td.deleteTeacherById(id);
	}

}

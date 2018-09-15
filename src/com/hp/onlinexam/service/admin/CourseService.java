package com.hp.onlinexam.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.CourseDao;
import com.hp.onlinexam.dao.admin.ICourseDao;
import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseService implements ICourseService{
	ICourseDao cd = new CourseDao();
	@Override
	public List<TeacherCourseView> findAll() {
		// TODO Auto-generated method stub
		return cd.findAllTeaCourInfo();
	}

	@Override
	public TeacherCourseView findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findTeaCourInfoById(id);
	}

	@Override
	public Map<String, Object> findCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findCourseById(id);
	}

	@Override
	public List<Map<String, Object>> findAllCourses() {
		// TODO Auto-generated method stub
		return cd.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		return cd.findAllCoursesByName(name);
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return cd.findTeaCourInfoByCourseKey(courseKey);
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		// TODO Auto-generated method stub
		cd.deleteTCourse(tcId);
	}

	@Override
	public void addCourse(String courseName) {
		// TODO Auto-generated method stub
		cd.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		cd.addSchedule(tc);
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub

		return cd.findCoursesByTeacherId(teaId);
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		cd.deleteCourse(id);
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		cd.updateTeacherCourse(tc);
	}

}

package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao{

	DBUtil db = new DBUtil();
	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		// TODO Auto-generated method stub
		String sql = "select tc.id tcId, tc.teacherId, "
				+ "t.name teacherName, tc.courseId, "
				+ "c.name courseName, tc.classId, "
				+ "sc.name className FROM teach_course tc, "
				+ "teacher t, course c, stu_class sc "
				+ "where tc.teacherId = t.id "
				+ "and tc.courseId = c.id "
				+ "and tc.classId = sc.id";
		List tcList = new ArrayList();
		try {
			tcList = db.getQueryList(TeacherCourseView.class, sql, new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tcList = new ArrayList();
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		String sql = "insert into course(name) values (?)";
		try {
			db.execute(sql, new Object[] {name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "update course set name = ? where id = ?";
		try {
			db.execute(sql, new Object[] {course.getName(), course.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findCourseById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from course where id = ?";
		Map<String, Object> couMap = new HashMap();
		try {
			couMap = db.getObject(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			couMap = new HashMap();
			e.printStackTrace();
		}
		return couMap;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		String sql = "select tc.id tcId, tc.teacherId, "
				+ "t.name teacherName, tc.courseId, "
				+ "c.name courseName, tc.classId, "
				+ "sc.name className FROM teach_course tc, "
				+ "teacher t, course c, stu_class sc "
				+ "where tc.teacherId = t.id "
				+ "and tc.courseId = c.id "
				+ "and tc.classId = sc.id"
				+ " and tc.id = ?";
		TeacherCourseView tcv = new TeacherCourseView();
		try {
			tcv = (TeacherCourseView)db.getObject(TeacherCourseView.class, sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tcv = new TeacherCourseView();
			e.printStackTrace();
		}
		return tcv;
	}

	@Override
	public List<Map<String, Object>> findAllCourses() {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		List cList = new ArrayList();
		try {
			cList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			cList = new ArrayList();
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from course";
		if(!"".equals(name)) {
			sql += " where name like '%"+ name +"%'";
		}
		List couList = new ArrayList();
		try {
			couList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/**
			 * 出异常之后，teaList可能是null或者异常之后，程序执行有问题
			 */
			couList = new ArrayList();
			e.printStackTrace();
		}
		return couList;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub
		String sql = "update teach_course set courseId = ?, teacherId=?, classId = ? where id = ?";
		try {
			db.execute(sql, new Object[] {tc.getCourseId(), tc.getTeacherId(), tc.getClassId(), tc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		String sql = "select tc.id tcId, tc.teacherId, "
				+ "t.name teacherName, tc.courseId, "
				+ "c.name courseName, tc.classId, "
				+ "sc.name className FROM teach_course tc, "
				+ "teacher t, course c, stu_class sc "
				+ "where tc.teacherId = t.id "
				+ "and tc.courseId = c.id "
				+ "and tc.classId = sc.id";
		if(!"".equals(courseKey)) {
			sql += " and (t.name like '%"+ courseKey +"%'";
			sql += " or c.name like '%"+ courseKey +"%'";
			sql += " or sc.name like '%"+ courseKey +"%')";
		}
		List tcList = new ArrayList();
		try {
			tcList = db.getQueryList(TeacherCourseView.class, sql, new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tcList = new ArrayList();
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public void deleteTCourse(int tcId) {
		// TODO Auto-generated method stub
		String sql = "delete from teach_course where id = ?";
		try {
			db.execute(sql, new Object[] {tcId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select * from course where id in (select courseId from teach_course where teacherId = ?)";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class, sql, new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from course where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addSchedule(TeacherCourse tc) {
		String sql = "insert into teach_course(courseId, teacherId, classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[] {tc.getCourseId(),tc.getTeacherId(), tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

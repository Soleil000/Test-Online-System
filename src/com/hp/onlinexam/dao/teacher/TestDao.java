package com.hp.onlinexam.dao.teacher;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;

public class TestDao implements ITestDao{
	private DBUtil db = new DBUtil();
	@Override
	public void createTest(Test t) {
		// TODO Auto-generated method stub
		String sql = "insert into test(name,courseId,endDate,questions,teacherId,classIds,scores,testTime)"
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {t.getName(),t.getCourseId(),t.getEndDate(),t.getQuestions(),t.getTeacherId(),t.getClassIds(),t.getScores(),t.getTestTime()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		/**
		 * group_concat(sc.name) 可以把查询出的sc.name多条记录的字段值转换成一个字段
		 * find_in_set(sc.id,classIds) 第一个是一个字段的值，第二个是一个集合，将第一个字段在集合的记录都查出来
		 * 可以查记录，可以查字段
		 * 要查的是试卷，需要根据试卷分组， group by t.id
		 */
		String sql = "select t.id, t.name, t.endDate,t.testTime, "
				+ "t.scores, c.name as cName, group_concat(sc.name) classNames from test t, course c, stu_class sc" + 
				" where t.courseId = c.id and find_in_set(sc.id,t.classIds) and t.teacherId = ? group by t.id";
		List<Map<String, Object>> testList = new ArrayList<Map<String, Object>>();
		try {
			testList = db.getQueryList(sql, new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		// TODO Auto-generated method stub
		String sql = "select t.name, t.endDate, t.testTime, t.questions, "
				+ "t.scores, c.name as cName, group_concat(sc.name) classNames from test t, course c, stu_class sc" + 
				" where t.courseId = c.id and find_in_set(sc.id,t.classIds) and t.teacherId = ? and t.id = ?";
		Map<String, Object> testMap = new HashMap<String, Object>();
		try {
			testMap = db.getObject(sql, new Object[] {teaId, id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		String sql = "select t.id, t.courseId, t.name testName, t.endDate, t.testTime, t.questions, "
				+ "t.scores, c.name as courseName, sc.name className from test t, course c, stu_class sc, student s" + 
				" where t.courseId = c.id and s.classId = sc.id and s.id = ? and t.id = ?";
		Map testMap = new HashMap<Object, Object>();
		try {
			testMap = db.getObject(sql, new Object[] {studentid, testid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testMap = new HashMap<Object, Object>();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, Timestamp currData, String key) {
		// TODO Auto-generated method stub
		String sql = "select t.id, t.name as testName,t.endDate, "
				+ "t.courseId, c.name as cName from test t, "
				+ "student s, course c where t.courseId = c.id "
				+ "and t.endDate >= ? and s.id = ? and "
				+ " FIND_IN_SET(s.classId,t.classIds) "
				+ "and t.id not in(select testId from stu_test where s.id = stu_test.studentId) ";
		if(!"".equals(key)) {
			sql += " and (t.name like '%"+ key +"%'";
			sql += " or c.name like '%"+ key +"%')";
		}
		List<Map<String, Object>> testList = new ArrayList<Map<String, Object>>();
		try {
			testList = db.getQueryList(sql, new Object[] {currData, id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return testList;
	}

}

package com.hp.onlinexam.service.teacher;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.ITestDao;
import com.hp.onlinexam.dao.teacher.TestDao;
import com.hp.onlinexam.po.Test;

public class TestService implements ITestService {
	private ITestDao td = new TestDao();
	@Override
	public void createTest(Test t) {
		// TODO Auto-generated method stub
		td.createTest(t);
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		// TODO Auto-generated method stub
		/**
		 * 过期试卷不显示
		 */
		List<Map<String, Object>> testList = td.findTestsByTeaId(teaId);
		List<Map<String, Object>> tList = new ArrayList<Map<String, Object>>();
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		for(int i=0; i<testList.size();i++) {
			if(d.before((Timestamp) testList.get(i).get("endDate"))) {
				tList.add(testList.get(i));
			}
		}
		return tList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		// TODO Auto-generated method stub
		return td.findTestById(id, teaId);
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		// TODO Auto-generated method stub
		return td.findStudentTestsById(studentid, testid);
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, Timestamp currData, String key) {
		// TODO Auto-generated method stub
		return td.getTestByStudent(id, currData, key);
	}

}

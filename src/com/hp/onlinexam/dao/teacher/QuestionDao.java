package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Questions;
import com.hp.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {

	private DBUtil db = new DBUtil();
	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		// TODO Auto-generated method stub
		String sql = "select q.id, q.courseId, q.queType, q.queTitle, "
				+ "q.choiceA, q.choiceB, q.choiceC, q.choiceD, "
				+ "q.ans, c.name from questions q, course c "
				+ "where q.courseId = c.id and queExist=1";
		if(null!=key && !"".equals(key)) {
				sql += " and "+key+" like '%"+value+"%'";
		}
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>(); 
		try {
			queList = db.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			queList = new ArrayList<Map<String, Object>>(); 
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void addQuestion(Questions q) {
		// TODO Auto-generated method stub
		String sql = "insert into questions(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		String sql = "select q.id, q.courseId, q.queType, q.queTitle, "
				+ "q.choiceA, q.choiceB, q.choiceC, q.choiceD, "
				+ "q.ans, c.name from questions q, course c "
				+ "where q.courseId = c.id and q.id = ?";
		Map<String, Object> queMap = new HashMap<String, Object>(); 
		try {
			queMap = db.getObject(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			queMap = new HashMap<String, Object>(); 
			e.printStackTrace();
		}
		return queMap;
	}

	@Override
	public List<Questions> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where id in ("+ids+")";
		List quesList = new ArrayList();
		try {
			quesList = db.getQueryList(Questions.class, sql, new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			quesList = new ArrayList<Questions>();
			e.printStackTrace();
		}
		return quesList;
	}

	@Override
	public void updateQuestionInfo(Questions q) {
		// TODO Auto-generated method stub
		String sql = "update questions set courseId = ?,queType=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,ans=? where id = ?";
		try {
			db.execute(sql, new Object[] {q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		String sql = "select * from questions where courseId = ? and queExist=1";
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql, new Object[] {courseId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			queList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		String sql = "update questions set queExist = 0 where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

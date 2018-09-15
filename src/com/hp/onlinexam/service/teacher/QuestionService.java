package com.hp.onlinexam.service.teacher;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IQuestionDao;
import com.hp.onlinexam.dao.teacher.QuestionDao;
import com.hp.onlinexam.po.Questions;

public class QuestionService implements IQuestionService {

	private IQuestionDao qd = new QuestionDao();
	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Questions q) {
		// TODO Auto-generated method stub
		qd.addQuestion(q);
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return qd.findQuestionById(id);
	}

	@Override
	public void updateQuestionInfo(Questions q) {
		// TODO Auto-generated method stub
		qd.updateQuestionInfo(q);
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		qd.deleteQuestion(id);
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> queList = qd.findQuestionsByCourseId(courseId);
		/**
		 * 通过shuffle方法做随机，num是多少就取前几个。
		 */
		Collections.shuffle(queList);
		if(num>=queList.size()) {
			return queList;
		}
		else {
			return queList.subList(0, num);
		}
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		if(null==list) {
			return "";
		}
		/**
		 * 字符串的拼接尽量用StringBuffer
		 * 因为String不可变 例如String s = "a"+"b"; s+="c";会同时创建两个对象"ab"、"abc"。
		 * 
		 */
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<list.size(); i++) {
			Map<String,Object> questionMap = list.get(i);
			sb.append(questionMap.get("id")+",");
		}
		String ids = sb.toString();
		if(list.size()>0)
			return ids.substring(0,ids.length()-1);
		return ids;
	}

	@Override
	public List<Questions> findQuestionByIds(String ids) {
		// TODO Auto-generated method stub
		return qd.findQuestionByIds(ids);
	}

	@Override
	public List findQuestions(String key, String value, int page, int count) {
		// TODO Auto-generated method stub
		List quesList = qd.findAllQuestionInfo(key, value);
		return quesList.subList((page-1)*count, (page-1)*count+count);
	}

}

package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Papers;



public interface IPaperService { 
	
	public int save(Papers paper);
	/**
	 * 学生试题
	 * @return
	 */
	public List getPaperByStudentId(int studentId,int testId);
	
	/**
	 * 学生以往答过的试卷
	 * @return
	 */
	public List getPaperByStudentId(int studentId, String name);
	
	/**
	 * 获得班级评估信息
	 * @return
	 */
	public List getPaperCompare(int teaId, String key);
	public Map<String, Object> getPaperInfoByStudentId(int id, int studentId);
}

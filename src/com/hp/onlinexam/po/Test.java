package com.hp.onlinexam.po;

import java.sql.Timestamp;

public class Test {
	private int id;
	private int courseId;
	private String name;
	private Timestamp endDate;
	private String questions;
	private String classIds;
	private int teacherId;
	private String scores;
	private int testTime;
	
	public Test() {}
	public Test(int id, int courseId, String name, Timestamp endDate, String questions,
			String classIds, int teacherId, String scores,int testTime) {
		this.id = id;
		this.courseId = courseId;
		this.name = name;
		this.endDate = endDate;
		this.questions = questions;
		this.classIds = classIds;
		this.teacherId = teacherId;
		this.scores = scores;
		this.testTime = testTime;
	}
	public Test(int courseId, String name, Timestamp endDate, String questions,
			String classIds, String scores,int testTime) {
		this.courseId = courseId;
		this.name = name;
		this.endDate = endDate;
		this.questions = questions;
		this.classIds = classIds;
		this.scores = scores;
		this.testTime = testTime;
	}
	
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	
	public String toString(){
		return "试卷编号:"+id+" 试卷名称:"+name+" 课程编号:"+courseId+" 结束时间:"+endDate+" 试题列表:"+questions+" 教师编号:"+teacherId+" 适用班级:"+classIds+" 满分:"+scores+" 考试时间:"+testTime;
	}
	
}

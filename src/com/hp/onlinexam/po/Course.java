package com.hp.onlinexam.po;

/**
 * 课程类
 */
public class Course {
	/**
	 *java数据类型--基本数据类型：byte short int long float double char boolean
	 *java数据类型--引用数据类型：类、接口、数组
	 */
	private int id;
	private String name;
	/**
	 * java访问权限:private、protected、public、默认default
	 */
	public Course() {}
	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

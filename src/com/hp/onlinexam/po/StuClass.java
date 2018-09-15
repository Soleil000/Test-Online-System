package com.hp.onlinexam.po;

public class StuClass {
	private int id;
	private String name;
	private String deptName;
	
	public StuClass() {}
	public StuClass(int id, String name, String deptName) {
		this.id = id;
		this.name = name;
		this.deptName = deptName;
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
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}

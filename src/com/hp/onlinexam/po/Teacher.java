package com.hp.onlinexam.po;

public class Teacher {
	private int id;
	private String name;
	private String pwd;
	private String deptName;
	
	public Teacher() {}
	public Teacher(int id, String name, String pwd, String deptName) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao{

	DBUtil db = new DBUtil();
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into student(name,pwd,school,deptName,sex,born,classId) values"
				+ "(?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		String sql = "update student set name=?,pwd=?,school=?,deptName=?,sex=?,born=?,classId=? where id = ?";
		try {
			db.execute(sql, new Object[] {s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId(), s.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String,Object> findStudentById(int id) {
		// TODO Auto-generated method stub
		String sql = "select s.id,s.pwd,s.name,s.sex,s.born, s.school, sc.id as sid, sc.name as cname, s.deptName from student s, "
				+ "stu_class sc where s.id = ? and s.classId = sc.id";
		Map sMap = new HashMap();
		try {
			sMap = db.getObject(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sMap;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findAllByName(String name) {
		// TODO Auto-generated method stub
		/**
		 * 多表查询：
		 * 用不到的字段尽量不查
		 * 两表中有相同字段利用as给字段起别名
		 */
		String sql = "select s.id,s.name,s.sex,s.born, s.school, sc.id as sid, sc.name as cname, s.deptName from student s, "
				+ "stu_class sc where s.classId = sc.id";
		if(!"".equals(name)) {
			sql += " and s.name like '%"+ name +"%'";
		}
		sql += "  order by s.id";
		List<Map<String, Object>> stuList = new ArrayList<Map<String, Object>>();
		try {
			stuList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/**
			 * 出异常之后，teaList可能是null或者异常之后，程序执行有问题
			 */
			stuList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from student where id = ?";
		try {
			db.execute(sql, new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.hp.onlinexam.dao.login;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao {

	private DBUtil db = new DBUtil();
	
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where name = ? and pwd = ?";
		Teacher t2 = new Teacher();	
		try {
			t2 = (Teacher)db.getObject(Teacher.class, sql, new Object[] {t.getName(), t.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t2 = new Teacher();	
			e.printStackTrace();
		}
		return t2;
	}

	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		String sql = "select * from student where name = ? and pwd = ?";
		Student s2 = new Student();	
		try {
			s2 = (Student)db.getObject(Student.class, sql, new Object[] {s.getName(), s.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			s2 = null;	
			e.printStackTrace();
		}
		return s2;
	}

}

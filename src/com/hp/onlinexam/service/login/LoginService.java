package com.hp.onlinexam.service.login;

import com.hp.onlinexam.dao.login.ILoginDao;
import com.hp.onlinexam.dao.login.LoginDao;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;

public class LoginService implements ILoginService {

	private ILoginDao ld = new LoginDao();
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		return ld.canLogin(t);
	}

	public Student canLogin(Student s) {
		// TODO Auto-generated method stub
		return ld.canLogin(s);
	}

}

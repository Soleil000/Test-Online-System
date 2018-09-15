package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;
import com.hp.onlinexam.util.Encrypt;

@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet{

	private Student s = new Student();
	private IStudentService ss = new StudentService();
	private IStuClassService scs = new StuClassService();
	private Encrypt e = new Encrypt();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List classList = scs.findClassNames();
		req.setAttribute("classList", classList);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/studentadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("stuname");
		String password = req.getParameter("pwd");
		String pwd = e.convertMD5(password);
		String deptName = req.getParameter("depInfo");
		String born = req.getParameter("birthday");
		String sex = req.getParameter("sex");
		String school = req.getParameter("school");
		String classId = req.getParameter("classInfo");
		s.setName(name);
		s.setPwd(pwd);
		s.setDeptName(deptName);
		s.setBorn(born);
		s.setClassId(Integer.valueOf(classId));
		s.setSchool(school);
		s.setSex(sex);
		
		ss.addStudent(s);
		/**
		 * getRequestDispatcher带着request和response跳转
		 * 若不需要保留请求和相应则使用resp.setRedirect
		 */
		resp.sendRedirect(req.getContextPath()+"/StudentQueryServlet");
	}
	
}

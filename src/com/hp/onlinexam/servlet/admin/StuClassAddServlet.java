package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

@WebServlet("/StuClassAddServlet")
public class StuClassAddServlet extends HttpServlet{
	private StuClass sc = new StuClass();
	private IStuClassService scs = new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/stuclassadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		// TODO Auto-generated method stub
		/**
		 * 获取请求参数
		 */
		String stuName = req.getParameter("stuname");
		String deptName = req.getParameter("depInfo");
		
		
		/**
		 * 把请求参数封装成对象
		 * 封装的目的是为了调用业务层的方法
		 */
		
		sc.setName(stuName);
		sc.setDeptName(deptName);
		/**
		 * 调用业务层方法
		 */
		
		scs.addstuClass(sc);
		req.getRequestDispatcher("/StuClassQueryServlet").forward(req, resp);
	}

}

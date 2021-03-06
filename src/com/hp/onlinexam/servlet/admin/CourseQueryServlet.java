package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/CourseQueryServlet")
public class CourseQueryServlet extends HttpServlet{
	private ICourseService cs = new CourseService();
	private Course c = new Course();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("couname");
		if(null == name) {
			name = "";
		}
		List couList = cs.findAllCourses(name);
		if(couList.size()==0) {
			req.setAttribute("error", "无相关搜索结果！");
		}
		req.setAttribute("couList", couList);
		req.getRequestDispatcher("manager/coursemanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}

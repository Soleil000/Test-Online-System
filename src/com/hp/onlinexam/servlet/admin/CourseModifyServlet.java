package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/CourseModifyServlet")
public class CourseModifyServlet extends HttpServlet{
	private ICourseService cs = new CourseService();
	Course c = new Course();
	/**
	 * 用来获取当前对象并把当前对象送到要跳转的页面
	 * 页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String id = req.getParameter("id");
			Map<String, Object> couMap = cs.findCourseById(Integer.valueOf(id));
			req.setAttribute("Course", couMap);
			req.getRequestDispatcher("manager/coursemodify.jsp").forward(req, resp);
	} 

	/**
	 * 在页面上修改当前对象的值，提交，页面跳转
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = req.getParameter("courseId");
		String name = req.getParameter("couname");
		c.setId(Integer.valueOf(id));
		c.setName(name);
		cs.updateCourse(c);
		resp.sendRedirect(req.getContextPath()+"/CourseQueryServlet");
	}

}


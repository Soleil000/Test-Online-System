package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
/**
 * 查询班级信息
 * @author xb
 */
@WebServlet("/StuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet{

	private IStuClassService scs = new StuClassService();
	@Override
	/**
	 * 一般查询用doget
	 * 改动用dopost
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * servlet职能：
		 * 1. 接受用户请求
		 * 2. 从业务层获取结果
		 * 3. 把结果封装并传递到界面
		 * 4. 页面跳转
		 */
		String name = req.getParameter("scname");
		if(null == name) {
			name = "";
		}
		List stuClassList = scs.findAll(name);
		/**
		 * 使用req.setAttribute将结果放到页面
		 * 第一个参数是key，第二个参数是value
		 */
		if(stuClassList.size()==0) {
			req.setAttribute("error", "无相关搜索结果！");
		}
		req.setAttribute("scList", stuClassList);
		req.getRequestDispatcher("manager/stuclassmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		doGet(req, resp);
	}
	
}

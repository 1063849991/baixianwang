package com.zd.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zd.dao.EmpDao;
import com.zd.service.EmpService;
import com.zd.service.impl.EmpServiceImpl;


@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//获取页面传来的id
		String[] ids=request.getParameterValues("anycheck");
		//调用service
		EmpService dd=new EmpServiceImpl();
		dd.deleteEmpById(ids);
		response.sendRedirect("EmpMoHuLike");
	}

}

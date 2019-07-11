package com.zd.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zd.pojo.Emp;
import com.zd.service.EmpService;
import com.zd.service.impl.EmpServiceImpl;

@WebServlet("/ToUpdateServlet")
public class ToUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		EmpService ue=new EmpServiceImpl();
		Emp e=new Emp();
		//获取页面传来的ID
		String id=request.getParameter("anycheck");
		e=ue.queryEmpById(new Integer(id));
		request.setAttribute("elist", e);
		request.getRequestDispatcher("update.jsp").forward(request, response);
		
	}

}

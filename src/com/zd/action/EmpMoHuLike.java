package com.zd.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zd.pojo.Emp;
import com.zd.pojo.FenYe;
import com.zd.pojo.Query;
import com.zd.service.EmpService;
import com.zd.service.impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpMoHuLike
 */
@WebServlet("/EmpMoHuLike")
public class EmpMoHuLike extends HttpServlet {
    public EmpMoHuLike() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//封装查询条件
		Query query=new Query();
		String qEname=request.getParameter("ename");
		if (qEname==null) {
			qEname="";
		}
		
		query.setQename(qEname);
		
		String qDeptno=request.getParameter("deptno");
		if (qDeptno!=null && !"".equals(qDeptno)) {
			query.setQdeptno(new Integer(qDeptno));
		}else {
			qDeptno="";
		}
		
		//封装分页对象
		FenYe fy=new FenYe();
		//处理分页对象的操作放到service层,调用service完成数据库
		String pg=request.getParameter("pg");
		EmpService ew=new EmpServiceImpl();
		List<Emp> dd=ew.queryEmpByFy(fy, pg, query);

		request.setAttribute("fy", fy);
		request.setAttribute("query", query);
		request.setAttribute("empList", dd);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}

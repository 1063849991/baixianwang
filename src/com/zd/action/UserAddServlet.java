package com.zd.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zd.pojo.Userl;
import com.zd.service.UserlService;
import com.zd.service.impl.UserlServiceImpl;
import com.zd.util.MD5;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String json="";
		//封装到实体类
		UserlService ue=new UserlServiceImpl();
		Userl e=new Userl();
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		if (ue.queryEmpByName(username)!=null ) {
			//查到已存在相同的用户名不能新增
			json="{\"mess\":false}";
		}else {
			e.setUserName(username);
			e.setuPassword(MD5.GetMD5Code(userpwd));
			ue.addUserl(e);
			
			//没有查到已存在的用户名可以新增
			json="{\"mess\":true}";
		}
		//把需要发送给客户端的信息响应给客户端
		PrintWriter pw=response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
		
		
	}

}

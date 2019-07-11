package com.zd.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zd.pojo.Userl;
import com.zd.service.UserlService;
import com.zd.service.impl.UserlServiceImpl;
import com.zd.util.MD5;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    public UserServlet() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//获取表单的值ֵ
		String username=request.getParameter("username");
		String userpassword=request.getParameter("userpwd");
		String isno=request.getParameter("isno");
		String json="";
		
		Userl ac=new Userl();
		if (username!=null &&!"".equals(username)&&userpassword!=null&&!"".equals(userpassword)) {
			ac.setUserName(username);
			if(userpassword.length()<32){
				ac.setuPassword(MD5.GetMD5Code(userpassword));
			}else{
				ac.setuPassword(userpassword);
			}
		}
		//调用对应的service，然后service调用dao完成对数据库的查询
		UserlService us=new UserlServiceImpl();
		ac=us.selectUser(ac);
		if(ac!=null){
			//登录成功，保存用户登录状态
			HttpSession session=request.getSession();
			session.setAttribute("userSession",ac);
			if("yes".equals(isno)){
				//用户需要保存，创建cookie对象
				Cookie b=new Cookie("username",URLEncoder.encode(ac.getUserName(), "utf-8"));
				Cookie c=new Cookie("userpwd",ac.getuPassword());
				//设置cookie路径
				b.setPath("/car");
				c.setPath("/car");
				//设置cookie有效时间
				b.setMaxAge(24*60*60);
				c.setMaxAge(24*60*60);
				//ͨresponse对象吧cookie发送给客户端
				response.addCookie(b);
				response.addCookie(c);			
			}
			//登录成功
			json="{\"mess\":true}";
			
		} else{
			//登录失败
			json="{\"mess\":false}";
			
		}
		//把需要发送给客户端的信息响应给客户端
		PrintWriter pw=response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
	}


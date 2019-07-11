package com.zd.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.zd.pojo.Emp;
import com.zd.service.EmpService;
import com.zd.service.FileUpLoadService;
import com.zd.service.impl.EmpServiceImpl;
import com.zd.service.impl.FileLoadServiceImpl;

@WebServlet("/EmpAddServlet")
public class EmpAddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

			//创建缓存对象工厂
			DiskFileItemFactory dfi=new DiskFileItemFactory();
			//创建上传的核心对象
			ServletFileUpload sfu=new ServletFileUpload(dfi);
			//核心对象解析多部件表单
			try {
				List<FileItem> fs=sfu.parseRequest(request);
				//把处理List<FileItem>集合的操作放到一个单独的上传的service里面
				FileUpLoadService fus=new FileLoadServiceImpl();
				EmpService ns=new EmpServiceImpl();
				Emp n=fus.newsUpload(fs);
				ns.addEmp(n);
				//跳转页面
				response.sendRedirect("EmpMoHuLike");
			} catch (FileUploadException e1) {
				e1.printStackTrace();
			}
	}

}

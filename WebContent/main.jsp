<%@page import="com.zd.pojo.Emp"%>
<%@page import="com.zd.dao.EmpDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.zd.pojo.Userl"%>
<%@page import="com.zd.dao.UserlDao"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>主页面</title>
	<link rel="stylesheet" type="text/css" href="css/index3.css"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/index2.js" type="text/javascript" charset="utf-8"></script>
  </head>
  
  <body>
	
	
  	<div id="all">
		<div id="header">
			<a>欢迎 ${userSession.userName}登录</a><button><a href="${pageContext.request.contextPath }/OutServlet">退出系统</a></button>
		</div>
		<div id="header2">
			  <form method="post" action="${pageContext.request.contextPath }/EmpMoHuLike">
					<p>
						员工姓名：<input type="text" id="ename" name="ename" value=""/>
						部门号：<input type="text" id="deptno" name="deptno" value=""/>
					
						<input type="submit" value="搜索"/>
					</p>
			 </form>
		</div>
		<div id="body">
		<form method="post" action="${pageContext.request.contextPath }/DelServlet" onsubmit="return confirm('是否确定全部删除??')">
			<table border="1" width="700px">
			    <tr align="center">
			    	<th>全选<input type="checkbox" name="allcheck" onclick="myAllBox(this)"/></th>
			        <th>工号</th>
			        <th>姓名</th>
			        <th>工作</th>
			        <th>上级</th>
			        <th>入职日期</th>
			        <th>工资</th>
			        <th>奖金</th>
			        <th>部门</th>
			        <th>头像</th>
			        <th>删除信息</th>
			        <th>修改信息</th>
			    </tr>
			    <c:forEach items="${empList}" var="Emp" varStatus="status">
			    <tr align="center">
			        <td><input type="checkbox" name="anycheck" onclick="mySubBox()" value="${Emp.empno}"/></td>
			        <td>${Emp.empno}</td>
			        <td>${Emp.ename}</td>
			        <td>${Emp.job}</td>
			        <td>${Emp.mgr}</td>
			        <td><fmt:formatDate value='${Emp.hiredate}' pattern='yyyy-MM-dd'/></td>
			        <td>${Emp.sal}</td>
			        <td>${Emp.comm}</td>
			        <td>${Emp.deptno}</td>
			        <td><img src="${pageContext.request.contextPath }/${Emp.pic}"/></td>
			        <td><a href="${pageContext.request.contextPath }/DelServlet?anycheck=${Emp.empno}" onClick="confirm('确定要删除此条信息？')">删除</a></td>
			        <td><a href="${pageContext.request.contextPath }/ToUpdateServlet?anycheck=${Emp.empno}">修改</a></td>
			        
			    </tr>
			    </c:forEach>
			</table>
			<a href="add.jsp" class="ss"><input type="button" id="add" name="add" value="添加员工"/></a>
			<input type="submit" value="全部删除"/>
			</form>
		</div>
		<div id="footer">
			
			<div id="fooot-end">
				<ul>
					<li><a href="${pageContext.request.contextPath }/EmpMoHuLike?pg=1&ename=${query.qename}&deptno=${query.qdeptno}">首页</a></li>
					<li><a href="${pageContext.request.contextPath }/EmpMoHuLike?pg=${fy.page-1}&ename=${query.qename}&deptno=${query.qdeptno}">上一页</a></li>
					<li><a href="${pageContext.request.contextPath }/EmpMoHuLike?pg=${fy.page+1}&ename=${query.qename}&deptno=${query.qdeptno}">下一页</a></li>
					<li><a href="${pageContext.request.contextPath }/EmpMoHuLike?pg=${fy.pageCount}&ename=${query.qename}&deptno=${query.qdeptno}">尾页</a></li>
					<li>当前第${fy.page}页</li>
					<li>一共${fy.pageCount}页</li>
				</ul>
			</div>
		</div>
	</div>	
  </body>
</html>
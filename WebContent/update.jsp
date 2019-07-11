<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/index4.css"/>
	<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>
  	<script type="text/javascript" src="<%=basePath%>/My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
  		<div id="all">
		<div id="add">
			<h2 style="margin-left: 130px;">修改页面</h2>
			<form action="${pageContext.request.contextPath }/EmpUpdateServlet1" method="post" enctype="multipart/form-data">
				<p>员工编号：<input type="text" name="addEmpno" value="${elist.empno }" readonly="readonly"/></p>
				<p>员工姓名：<input type="text" name="addEname" value="${elist.ename }" maxlength="4"/></p>
				<p style="margin-left: 30px;">工作：<input type="text" name="addJob" value="${elist.job }"/></p>
				<p style="margin-left: 30px;">上级：<input type="text" name="addMgr" value="${elist.mgr }"/></p>
				<p>入职日期：<input type="date" name="addHiredate" value="<fmt:formatDate value='${elist.hiredate }' pattern='yyyy-MM-dd'/>" onclick="WdatePicker()" class="Wdate" readonly="readonly"/></p>
				<p style="margin-left: 30px;">工资：<input type="text" name="addSal" value="${elist.sal }"/></p>
				<p style="margin-left: 30px;">奖金：<input type="text" name="addComm" value="${elist.comm }"/></p>
				<p>部门编号：<input type="text" name="addDeptno" value="${elist.deptno }"/></p>
				<p>员工头像:<img src="${elist.pic }" /></p>
				<p><input type="file" name="addPic" value="${elist.pic }"/></p>
				<p style="margin-left: 110px;"><input type="submit" value="提交" /></p>
			</form>
		</div>
	</div>
  </body>
</html>
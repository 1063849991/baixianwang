<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新增员工</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index4.css"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>
  	<script type="text/javascript" src="<%=basePath%>/My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
  		<div id="all">
		<div id="add">
			<h2 style="margin-left: 130px;">新增页面</h2>
			<form action="${pageContext.request.contextPath }/EmpAddServlet" method="post" enctype="multipart/form-data">
				<p>员工编号：<input type="text" name="addEmpno"/></p>
				<p>员工姓名：<input type="text" name="addEname"/></p>
				<p style="margin-left: 30px;">工作：<input type="text" name="addJob"/></p>
				<p style="margin-left: 30px;">上级：<input type="text" name="addMgr"/></p>
				<p>入职日期：<input type="text" name="addHiredate" onclick="WdatePicker()" class="Wdate" readonly="readonly"/></p>
				<p style="margin-left: 30px;">工资：<input type="text" name="addSal"/></p>
				<p style="margin-left: 30px;">奖金：<input type="text" name="addComm"/></p>
				<p>部门编号：<input type="text" name="addDeptno"/></p>
				<p>员工头像：<input type="file" name="addPic"/></p>
				<p style="margin-left: 110px;"><input type="submit" value="提交" /></p>
			</form>
		</div>
	</div>
	</body>
  </body>
</html>
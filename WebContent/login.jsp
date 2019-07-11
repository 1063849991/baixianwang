<%@page import="java.net.URLEncoder"%>
<%@page import="com.zd.dao.UserlDao"%>
<%@page import="com.zd.pojo.Userl"%>
<%@page import="com.zd.pojo.Emp"%>
<%@page import="com.zd.dao.EmpDao"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
	<link rel="stylesheet" href="css/index.css" />
	<script type="text/javascript" src="jquery-2.1.4/jquery-2.1.4.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	$(function(){
		$("#but").click(function(){
			//发送一个ajax请求
			$.ajax({
				//该请求发送的地址
				url:"UserServlet",
				//提交方式
				type:"post",
				//预计服务器返回的数据格式
				dataType:"json",
				//需要发送的数据
				data:{"username":$("#username").val(),"userpwd":$("#userpwd").val()},
				/*
				请求成功以后的回调函数
					参数data:后台相应的数据最终会被ajax封装到参数对象(js对象)中
				*/
				success:function(data){
					if(data.mess){
						location.href="EmpMoHuLike";
					}else{
						$("#upwd").html("用户名或者密码错误...");
					}
				},
				error:function(data){
					alert("请求失败.......");
				}
			});
		});
	})
	</script>
  </head>
  <body>
  	<body>
  		 
			<div id="all">
    		<div id="denglu">
    			<p>
    				账号:<input type="text" name="username" id="username" value="${URLDecoder.decode(cookie.username.value, 'utf-8')}" onblur="myonblur(this)"/>
    				<span id="uid"></span>
    			</p>
    			<p>
    				密码:<input type="password" name="userpwd" id="userpwd" value="${cookie.userpwd.value }" onblur="myonblur(this)"/>
    				<span id="upwd"></span>
    			</p>
    			<p class="a2"><input type="checkbox" value="yes" name="isno">一天免登录</p>
    			<p>
    				<button id="but" style="margin-left:50px">登录</button>
    				<a class="a1" href="zhuce.jsp">注册账号</a>
    			</p>
    		</div>
    	</div>
	</body>
</html>
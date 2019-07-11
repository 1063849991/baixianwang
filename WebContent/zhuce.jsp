<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册</title>
	<link rel="stylesheet" href="css/index2.css" />
	<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery-2.1.4/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#but").click(function(){
			//发送一个ajax请求
			$.ajax({
				//该请求发送的地址
				url:"UserAddServlet",
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
						location.href="login.jsp";
					}else{
						$("#uid").html("已存在该用户");
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
  	<div id="all">
		<div id="body1">
			<a style="margin-left: 190px;font-size: 30px;">注册</a>
			
    			<p>
    				设置账号:<input type="text" name="username" id="username" value="" />
    				<span id="uid"></span>
    			</p>
    			<p>
    				设置密码:<input type="password" name="userpwd" id="userpwd" value="" />
    				<span id="upwd"></span>
    			</p>
    			<p id="butt">
    				<input type="button" value="提交注册" style="width: 70px;height: 25px;margin-left: 80px;"  id="but"/>
    			</p>
    			
		</div>
	</div>	
  </body>
</html>
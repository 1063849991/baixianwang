
function myonblur(obj){
	var a=document.getElementById("username").value;
	var b=document.getElementById("userpwd").value;
	var inputq=obj.id;
	if ("username"==inputq) {
		if(a!=""){
				document.getElementById("uid").innerHTML="";
						
					}else{
						document.getElementById("uid").innerHTML="*账号不能为空";
					}
	}
		if ("userpwd"==inputq) {
		if(b!=""){
				document.getElementById("upwd").innerHTML="";		
				}else{
						document.getElementById("upwd").innerHTML="*密码不能为空";	
					}
			}
		
}
$(function(){
		$("#but").click(function(){
			alert("----");
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
						alert("ssss");
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


	
	

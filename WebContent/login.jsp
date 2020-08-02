<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<link rel="icon" href="images/search.gif" type="img/x-ico" />
<link href="css/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function a() {
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	if(username ==""){
		alert("用户名不能为空");
		return false;
	}
	if(password ==""){
		alert("密码不能为空");
		return false;
	}
	loginForm.submit();
}
	
</script>
<body>
	<div id="top"></div> 
	<div id="main">
		<img src="images/login.jpg" id="main_bg"/>
		<div id="login_block">
			<form action="/webLibrary/login" method="post" id="loginForm">
				<table border="0">
					<tr>
						<td class="title">用户名:</td>
						<td class="input">
							<input type="text" name="username" id="username" class="login_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">密码:</td>
						<td class="input">
							<input type="password" name="password" id="password" class="login_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">用户类型:</td>
						<td class="input">
							<input type="radio" name="type" value="reader" checked="checked"/>&nbsp;&nbsp;读者&nbsp;&nbsp;
							<input type="radio" name="type" value="admin"/>&nbsp;&nbsp;管理员
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text"><a href='register.jsp'>注册账号</a></td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn" type="button" value="登录" onclick="a()"/>
							<input class="btn" type="reset" value="重置"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="footer">
		<div class="foot_content">
			CopyRight &copy; 2020 www.**********.com ljh
		</div>
		<div class="foot_content">
			版权所有 Library V1.0
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="icon" href="images/search.gif" type="img/x-ico" />
<link href="css/register.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function a() {
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var confirmpassword=document.getElementById("confirmpassword").value;
	var name=document.getElementById("name").value;
	var tel=document.getElementById("tel").value;
	var cardid=document.getElementById("cardid").value;
	if(username ==""){
		alert("用户名不能为空");
		return false;
	}
	if(password ==""){
		alert("密码不能为空");
		return false;
	}
	if(name ==""){
		alert("姓名不能为空");
		return false;
	}
	if(tel ==""){
		alert("电话不能为空");
		return false;
	}
	if(cardid ==""){
		alert("身份证不能为空");
		return false;
	}
	if(password != confirmpassword){
		alert("密码前后输入不一致，请重新输入");
		return false;
	}
	registerForm.submit();
}
</script>
</head>

<body>
	<div id="top"></div> 
	<div id="main">
		<img src="images/login.jpg" id="main_bg"/>
		<div id="register_block">
			<form action="/webLibrary/register" method="post" id="registerForm">
				<table border="0">
					<tr>
						<td class="title">用户名:</td>
						<td class="input">
							<input type="text" name="username" id="username" class="register_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">密码:</td>
						<td class="input">
							<input type="password" name="password" id="password" class="register_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">确认密码:</td>
						<td class="input">
							<input type="password" name="confirmpassword" id="confirmpassword" class="register_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">用户姓名:</td>
						<td class="input">
							<input type="text" name="name" id="name" class="register_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">电话:</td>
						<td class="input">
							<input type="text" name="tel" id="tel" class="register_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">身份证:</td>
						<td class="input">
							<input type="text" name="cardid" id="cardid" class="register_input"/>
						</td>
					</tr>
					<tr>
						<td class="title">性别:</td>
						<td class="input">
							<input type="radio" name="gender" value="男" checked="checked"/>&nbsp;&nbsp;男
							<input type="radio" name="gender" value="女"/>&nbsp;&nbsp;女
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn" type="button" value="注册" onclick="a()"/>
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
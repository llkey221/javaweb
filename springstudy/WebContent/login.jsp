<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/login" method="post">
		<p>用户名：<input type="text" name="name"/></p>
		<p>密　码：<input type ="password" name="password"/></p>
		<p>验证码：<input type="text" name="checkcode"/>
		<img alt="验证码" src="${pageContext.request.contextPath}/checkcode" /></p>
		<p style="color:red"><%=(session.getAttribute("message")==null?"":session.getAttribute("message").toString()) %></p>
		<input type="submit" value="登录"/>
	</form>	
	<br/>
	<a href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
</body>
</html>
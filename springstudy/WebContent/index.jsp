<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
		this is Homepage!
		
		<%
			String name=(String)session.getAttribute("name");
			
			if(name==null||name==""){
		%>
		<a href="${pageContext.request.contextPath}/login.jsp">登录页</a>
		<%}else{ %>
			欢迎光临，${name }      <a href="${pageContext.request.contextPath }/user/logout">退出</a>
		<%} %>
</body>
</html>
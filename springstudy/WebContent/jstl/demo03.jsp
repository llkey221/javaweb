<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EL的9大隐藏对象</title>
</head>
<body>

-----------------1、pageContext--------------------
<%
	pageContext.setAttribute("user", "Richard");
%>
<br/>
${pageScope.user}
<br/>

----------------2、requestScope----------------
<br/>
<%
	request.setAttribute("url","http://baidu.com");
%>
${requestScope }<br/>
${requestScope.url }

<br/>
-----------------------3、sessionScope---------------------------
<%
	session.setAttribute("login","llkey");
%>
<br/>
${sessionScope }

${sessionScope.login }

<br/>
---------------------------------4、cookie--------------------------
<br/>

${cookie }
${cookie.JSESSIONID }
<br/>



</body>
</html>
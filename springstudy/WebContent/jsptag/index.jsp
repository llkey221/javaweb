<%@ page language="java"  contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jspf"></jsp:include>
<%@include file="header.jspf" %>
<h3>this is content</h3>
<jsp:forward page="forwardDemo01.jsp">
	<jsp:param value="param1" name="param1"/>
	<jsp:param value="param2" name="param2"/>
</jsp:forward>
<jsp:include page="foot.jspf"></jsp:include>
<%@include file="foot.jspf" %>
</body>
</html>
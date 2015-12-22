<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:catch var ="error">
		<c:import url="/index.jsp" context="/root" charEncoding="utf-8"></c:import>
	</c:catch>
	${error }
	
	<c:url value="http://www.baidu.com" var="url" >
		<c:param name="username" value="Richards"></c:param>
		<c:param name="pwd">123456</c:param>
	</c:url>
	<a href="${url }">百度(带参数)</a>
	
	<c:redirect url="http://www.baidu.com">
		<c:param name="name" value="richard"/>
		<c:param name="pwd">123456</c:param>
	</c:redirect>
</body>
</html>
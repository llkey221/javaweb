<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSTL练习</title>
</head>
<body>
	<c:out value="Hello world"></c:out>
	<c:out value="<br/><a href=http://www.cnblogs.com>博客园</a><br/>" escapeXml="false"/>
	<c:out value="<a href=http://www.cnblogs.com>博客园</a>"  escapeXml="true"/>
	
	<%
		List<String> list=new ArrayList<String>();
		list.add("Richard");
		list.add("LLKey");
		list.add("Tang");
		list.add("hua");
		request.setAttribute("list", list);
	%>
	
	<c:forEach var="item"  items="${list}"  varStatus="i">
		<br/><c:out value="${item}"/>
		&nbsp;&nbsp;<c:out value="${i.index }"></c:out>
		&nbsp;&nbsp;<c:out value="${i.count }"></c:out>
		&nbsp;&nbsp;<c:out value="${i.first }"></c:out>
		&nbsp;&nbsp;<c:out value="${i.last }"></c:out>
	</c:forEach>
	
	<c:forTokens items="北、京、欢、迎、你" delims="、"  var="str">
		<br/><c:out value="${str}"/>
	</c:forTokens>
	<c:catch var="error">
		<c:import url="http://www.baidu.com" charEncoding="utf-8"></c:import>
	</c:catch>
	${error}
</body>
</html>
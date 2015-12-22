<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <jsp:useBean id="person" class="com.study.javabean.Person" scope="page"/>
    <%
    	person.setName("唐华");
    	person.setAge(18);
    	person.setGender(1);
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<p>姓名：<%=person.getName() %></p>
	<p>年龄：<%=person.getAge() %></p>
	<p>性别：<%=person.getGender() %></p>
</body>
</html>
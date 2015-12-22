<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--jsp声明，通过%号，叹号，可以声明一个函数 --%>
	<%!
		public int GetNum(){
			return 10;
		}
		%>
		
		<%=GetNum() %>
		
		<%-- 
			pageContext.forward("");
		--%>
</body>
</html>
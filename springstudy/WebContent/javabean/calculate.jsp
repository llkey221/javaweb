<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:useBean id="calcBean" class="com.study.javabean.Calculater"></jsp:useBean>
    <%-- <jsp:setProperty property="*" name="calcBean"/>  --%>
    <jsp:setProperty property="num1" name="calcBean"  param="num1"/>
    <jsp:setProperty property="num2" name="calcBean" param="num2"/>
    <jsp:setProperty property="operator" name="calcBean" param="operator"/>
    <%
        		calcBean.calculate();
        %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
计算机的结果是：
<jsp:getProperty property="num1" name="calcBean"/>
<jsp:getProperty property="operator" name="calcBean"/>
<jsp:getProperty property="num2" name="calcBean"/>=
<jsp:getProperty property="result" name="calcBean"/>

<hr/>
	<form action="${pageContext.request.contextPath }/javabean/calculate.jsp" method="post">
		<table>
			<tr><td colspan=2>简单的计算器</td></tr>
			<tr><td>第一个参数：</td><td><input type="text" name="num1"/></td></tr>
			<tr><td>运算符：</td>
					<td>
						<select name="operator">
							<option selected>+</option>
							<option>-</option>
							<option>*</option>
							<option>/</option>
						</select>
					</td>
			</tr>
			<tr><td>第二个参数：</td><td><input type="text" name="num2"/></td></tr>
			<tr><td colspan=2><input type="submit" value="计算"/></td></tr>
		</table>
	</form>
</body>
</html>
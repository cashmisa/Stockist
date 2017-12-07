<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create User page</h1>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/admin/user/create">
	<table>
			<tr>
				<td>Username:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Role:</td>
				<td><form:input path="role" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><form:button type="submit" />create new user</td>
				<td></td>
			</tr>
	</table>
</form:form>
</body>
</html>
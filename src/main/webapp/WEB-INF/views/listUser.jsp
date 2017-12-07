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
<h1>User List page</h1>
<a href="${pageContext.request.contextPath}/admin/user/create">Add User</a>
	<table>
			<tr>
				<th>userName</th>
				<th>role</th>
				<th>password</th>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userName}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td align="center">
					<a href="${pageContext.request.contextPath}/admin/user/edit/${user.userName}.html">edit</a></td>
					<td>
					<a href="${pageContext.request.contextPath}/admin/user/delete/${user.userName}.html">delete</a></td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>
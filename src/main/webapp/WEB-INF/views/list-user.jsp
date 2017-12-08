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
<h1>User List</h1>
	<table>
			<tr>
				<th><spring:message code="fieldLabel.userName" /></th>
				<th>Role</th>
				<th>Password</th>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userName}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td align="center">
					<a href="${pageContext.request.contextPath}/admin/user/edituser/${user.userName}">
					Edit
					</a></td>
					<td>
					<a href="${pageContext.request.contextPath}/admin/user/deleteuser/${user.userName}">
					Delete
					</a></td>
				</tr>
			</c:forEach>
	</table>
	<div>
	<c:url var="add_url" value = "${pageContext.request.contextPath}/admin/user/create" />
	<a href="${add_url}">Add User</a>
	<br/>
	<c:if test="${createdUser == null}"><div id="createdUser" style="color:#0000ff">${createdUser}</div></c:if> 
	</div>
</body>
</html>

</script>
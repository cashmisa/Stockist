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
<h3>Edit User</h3>
<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/admin/user/edituser/${user.userName}">
<table>
			<tr>
				<td>Username:</td>	
				<td><form:input path="userName" readonly="true" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.user.role" /></td>
				<td><form:select path="role" items="${roleList}" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.user.password" /></td>
		 		<td><form:password path="password" /></td>
		 		<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:button type="submit"> Edit User </form:button></td>
				<td></td>
			</tr>
	</table>
</form:form>
</body>
</html>
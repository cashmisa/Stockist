<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<spring:message code="heading.user.addUser" />
</title>

<h3><spring:message code="heading.user.addUser" /></h3>
<form:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/admin/user/create">
	<table>
			<tr>
				<td><spring:message code="fieldLabel.user.userName" /></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" /></td>
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
				<td><form:button type="submit" class="btn btn-outline-primary" id="allButton"><spring:message code="button.addNew" /></form:button></td>
				<td><form:button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/admin/user'"><spring:message code="button.cancel" /></form:button></td>
				<td></td>
			</tr>
	</table>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<script src="/js/jquery.tablesorter.js"></script>
<title>
<spring:message code="heading.user.editUser" />
</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<h3><spring:message code="heading.user.editUser" /></h3>
<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/admin/user/edituser/${user.userName}">
<table>
			<tr>
				<td><spring:message code="fieldLabel.user.userName" /></td>	
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
				<td colspan="2"><form:button type="submit" class="btn btn-outline-primary" id="allButton"><spring:message code="button.saveChanges" /></form:button>
				<form:button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/admin/user'"><spring:message code="button.cancel" /></form:button>
				</td>
			</tr>
	</table>
</form:form>
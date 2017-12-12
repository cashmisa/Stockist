<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<title><spring:message code="heading.user.editUser" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<br />
<h3>
	<spring:message code="heading.user.editUser" />
</h3>
<hr />
<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/admin/user/edituser/${user.userName}">
	<table class="searchTable">
		<tr>
			<td><spring:message code="fieldLabel.user.userName" /></td>
			<td><form:input path="userName" readonly="true" cssStyle="color:#868e96;opacity:1" /></td>
			<td></td>
		</tr>

		<tr>
			<td><spring:message code="fieldLabel.user.role" /></td>
			<td><form:select path="role" items="${roleList}" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.user.password" /></td>
			<td><a
				href="${pageContext.request.contextPath}/admin/user/edituser/reset/${user.userName}">Reset
					password</a></td>
		</tr>
		<tr>
			<td> <a href="${pageContext.request.contextPath}/admin/user"
					class="btn btn-outline-primary"> <spring:message
							code="button.cancel" /></a>
			</td>
		</tr>
	</table>
</form:form>

<script src="/js/jquery.tablesorter.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<spring:message code="heading.user.addUser" />
</title>

<br/><h3><spring:message code="heading.user.addUser" /></h3><hr/>
<form:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/admin/user/create">
	<table class="searchTable">
			<tr>
				<td><spring:message code="fieldLabel.user.userName" /></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.user.role" /></td>
				<td><form:select path="role" items="${roleList}" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.user.password" /></td>
		 		<td><form:password path="password" /></td>
		 		<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:button type="submit" class="btn btn-outline-primary" id="allButton"><spring:message code="button.addNew" /></form:button>
				<a href="${pageContext.request.contextPath}/admin/user"
					class="btn btn-outline-primary"><spring:message code="button.cancel" /></a></td>
				<td></td>
			</tr>
	</table>
</form:form>
</body>
</html>
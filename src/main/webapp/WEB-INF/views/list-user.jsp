<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.user.userList" /></title>
</head>

<br />
<h3>
	<spring:message code="heading.user.userList" />
</h3>
<hr />

<c:url var="add_url"
	value="${pageContext.request.contextPath}/admin/user/create" />
<a href="${add_url}"><spring:message code="caption.user.add" /></a>

<br />
<c:if test="${message != null}">
	<div class="alert alert-primary" style="color: black" role="alert"
		id="createdUser">
		<h5>Great!</h5>
		<h6>${message}</h6>
	</div>
</c:if>
<br />
<noscript><h6><br><strong><spring:message code="message.enableJavaScript" /></strong></h6></noscript>
<table id="userTable" class="tablesorter" style="width:50%">
	<thead>
		<tr>
			<th><spring:message code="fieldLabel.user.userName" /></th>
			<th><spring:message code="fieldLabel.user.role" /></th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userName}</td>
				<td>${user.role}</td>
				<td><a
					href="${pageContext.request.contextPath}/admin/user/edituser/${user.userName}">
						<spring:message code="caption.edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/admin/user/deleteuser/${user.userName}">
						<spring:message code="caption.delete" />
				</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script src="/js/jquery.tablesorter.js"></script>
<script>
	$(document).ready(function() {
		$("#userTable").tablesorter({
			widgets : [ 'zebra' ],
			headers : {
				2 : {
					sorter : false
				},

				3 : {
					sorter : false
				}
			}
		});
	});
</script>   

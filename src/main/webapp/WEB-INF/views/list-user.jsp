<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<script src="/js/jquery.tablesorter.js"></script>
<script>
$(document).ready(function() {
	$("#userTable").tablesorter({
		headers : {
			3 : {
				sorter : false
			},

			4 : {
				sorter : false
			}
		}
	});
});	       
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<h3>User List</h3>
	
	<c:url var="add_url" value = "${pageContext.request.contextPath}/admin/user/create" />
	<a href="${add_url}"><spring:message code="caption.user.add"/></a>
	<br/>
	<c:if test="${createdUser != null}">
	<div id="createdUser" style="color:#000000">${createdUser}</div>
	</c:if> 
	
	<table id="userTable" class="tablesorter">
	<thead>
			<tr>
				<th><spring:message code="fieldLabel.userName" /></th>
				<th><spring:message code="fieldLabel.password" /></th>
				<th><spring:message code="fieldLabel.role" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
	</thead>
	<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userName}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td align="center">
					<a href="${pageContext.request.contextPath}/admin/user/edituser/${user.userName}">
					<spring:message code="caption.edit" />
					</a></td>
					<td>
					<a href="${pageContext.request.contextPath}/admin/user/deleteuser/${user.userName}">
					<spring:message code="caption.delete" />
					</a></td>
				</tr>
			</c:forEach>
	</tbody>
	</table>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>
<br>
<h3>Change Password</h3>
<hr />
<c:if test="${message!= null}">
	<div class="alert alert-primary" style="color: black" role="alert"
		id="message">
		<h5>Great!</h5>
		<h6>${message}</h6>
	</div>
</c:if>
<c:if test="${error != null}">
	<div class="alert alert-primary" style="color: black" role="alert"
		id="createdUser">
		<h5>Oops!</h5>
		<h6>${error}</h6>
	</div>
</c:if>
<form action="<spring:url value="/change-pass"/>" method="POST">
	<table class="searchTable">
		<tr>
			<td>Old Password</td>

			<td><input type="password" id="old-password" name="old-password" /></td>
		</tr>
		<tr>
			<td>New Password</td>
			<td><input type="password" id="new-password" name="new-password" /></td>
		</tr>
		<tr>
			<td colspan="2"><button class="btn btn-outline-primary" id="allButton">Submit</button>
				<a href="${pageContext.request.contextPath}/admin/user"
				class="btn btn-outline-primary"> <spring:message
						code="button.cancel" /></a>
		</tr>
	</table>
</form>

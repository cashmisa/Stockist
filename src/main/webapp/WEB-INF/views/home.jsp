<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello <spring:message code="world"/>!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<sec:authorize access="hasAnyAuthority('admin', 'mechanic')">
		<form action="/logout" method="post">
			<button id="logout">Sign out</button>
		</form>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<form action="/logout" method="post">
			<button id="logout">Sign out</button>
		</form>
	</sec:authorize>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
	<br/><h3>Hello <spring:message code="world"/>!</h3>

	<P>The time on the server is ${serverTime}.</P>

	<sec:authorize access="hasAnyAuthority('admin', 'mechanic')">
		<form action="/logout" method="post">
			<button id="logout">Sign out</button>
		</form>
	</sec:authorize>


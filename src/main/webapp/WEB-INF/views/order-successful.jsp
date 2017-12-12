<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.reorder.successful" /></title>

<br />
<c:if test="${message != null}">
	<div class="alert alert-primary" style="color: black" role="alert"
		id="createdUser">
		<h5>Great!</h5>
		<h6>${message}</h6>
	</div>
</c:if>

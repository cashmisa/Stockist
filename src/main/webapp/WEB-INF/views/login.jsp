<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<link href="/css/bootstrap4-business-tycoon.css" rel="stylesheet"
	type="text/css" />
<link href="/css/bootstrap-themes.css" rel="stylesheet" type="text/css" />
<link href="/css/blurred-bg.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/stockfavicon.ico" type="image/x-icon">
<link rel="icon" href="/stockfavicon.ico" type="image/x-icon">
<title>
<spring:message code="login.header" />
</title>

</head>
<body>
	<div class="background-image"></div>
	<div>
		<div id="reserved-space" style="height: 100px"></div>
		<div class="card content" style="width: 340px; margin: auto">
			<h5 class="card-header text-center">
				<spring:message code="login.header" />
			</h5>
			<form class="card-body" action="<spring:url value="/login"/>"
				method="post">

				<c:if test="${param.logout ne null}">
					<div class="alert alert-primary" role="alert">You have been
						logged out.</div>
				</c:if>
				<c:if test="${param.error ne null}">
					<div class="alert alert-danger" role="alert">Wrong username
						or password. Please try again.</div>
				</c:if>
				
				<div class="ht-tm-element ht-tm-element-inner">
					<spring:message code="login.username-label" var="un" />
					<input type="text" class="form-control" id="username"
						name="username" placeholder="${un}">
				</div>

				<div class="ht-tm-element ht-tm-element-inner">
					<spring:message code="login.password-label" var="pw" />
					<input type="password" class="form-control" id="password"
						name="password" placeholder="${pw}">
				</div>

				<button type="submit" class="btn btn-primary">
					<spring:message code="login.submit-label" />
				</button>
			</form>
		</div>
	</div>
</body>
</html>
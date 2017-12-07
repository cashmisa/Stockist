<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>
<link href="/css/bootstrap4-business-tycoon.min.css" rel="stylesheet"
	type="text/css" />
<link href="/css/bootstrap-themes.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="card">
		<div class="card-body">
			<form action="<spring:url value="/login"/>" method="post">

				<h6 class="card-title">Log In</h6>

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

				<button type="submit" class="btn btn-outline-primary">
					<spring:message code="login.submit-label" />
				</button>

			</form>
		</div>
	</div>
</body>
</html>
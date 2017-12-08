<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>
<link href="/css/bootstrap4-business-tycoon.min.css" rel="stylesheet"
	type="text/css" />
<link href="/css/bootstrap-themes.css" rel="stylesheet" type="text/css" />
<link href="/css/blurred-bg.css" rel="stylesheet" type="text/css" />
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
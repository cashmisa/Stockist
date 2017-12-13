<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarTogglerDemo03"
		aria-controls="navbarTogglerDemo03" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="/" style="width: 147px"><spring:message
			code="title.application" /></a>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-md-0">
			<li class="nav-item active"><a class="nav-link" href="/">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/about">About</a>
			</li>
		</ul>
		<div class="navbar-nav my-2 my-lg-0">
			<a href="/change-pass">
				<button class="btn btn-primary">
					Welcome,
					<sec:authentication property="principal.username" />
				</button>
			</a>
			<form action="/logout" method="post">
				<button id="logout" class="btn btn-primary">Sign out</button>
			</form>
		</div>
	</div>
</nav>
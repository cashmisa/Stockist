<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="/"><spring:message
				code="title.application" /></a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-md-0">
				<li class="nav-item active"><a class="nav-link" href="/">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#!">Disabled</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" placeholder="Search" type="text">
			</form>
			<div class="navbar-nav my-2 my-lg-0">
				<button class="btn btn-primary">
					Welcome,
					<sec:authentication property="principal.username" />
				</button>
				<form action="/logout" method="post">
					<button id="logout" class="btn btn-primary">Sign out</button>
				</form>
			</div>
		</div>
	</nav>
</div>
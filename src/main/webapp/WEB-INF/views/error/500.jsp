<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/css/bootstrap4-business-tycoon.css" rel="stylesheet"
	type="text/css" />
<link href="/css/font-awesome.css" rel="stylesheet" type="text/css" />
<link href="/css/bootstrap-themes.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="/stockfavicon.ico" type="image/x-icon">
<link rel="icon" href="/stockfavicon.ico" type="image/x-icon">
<title>500</title>
<script src="/js/jquery.js"></script>
<script src="/js/jquery-ui.js"></script>
</head>
<body>
	<div>
		<div id="m_menu_top">
			<%@ include file="/WEB-INF/decorators/menu-top.jsp"%>
		</div>
		<div class="jumbotron text-center">
			<h1 class="display-3">500: Internal Server Error</h1>
			<p class="lead">Well, this is embarrassing.</p>
		</div>
	</div>
	<div style="display: none;">
		<p>Failed URL: ${url}</p>
		<p></p>
	</div>
</body>
</html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<title><dec:title default="Web Page" /></title>
<script src="/js/jquery.js"></script>
<script src="/js/jquery-ui.js"></script>
<dec:head />
</head>
<body>
	<div>
		<!-- /top menu -->
		<div id="m_menu_top" style="position: fixed; top: 0; width: 100%">
			<%@ include file="menu-top.jsp"%>
		</div>

		<div id="m_container" style="margin-top: 56px">
			<div class="row" style="margin-right: 0px">
				<div class="col-md-2" style="position: relative">
					<%@ include file="sidebar.jsp"%>
					<div id="m_footer" style="bottom:0;position:fixed">
						<%@ include file="footer.jsp"%>
					</div>
				</div>
				<div class="col-md-10" style="position: static">
					<dec:body />
				</div>
			</div>
		</div>
		<!-- /main -->
	</div>
</body>
</html>
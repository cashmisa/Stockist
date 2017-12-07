<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/css/bootstrap4-business-tycoon.min.css" rel="stylesheet"
	type="text/css" />
<link href="/css/bootstrap-themes.css" rel="stylesheet" type="text/css" />
<title><dec:title default="Web Page" /></title>
<script src="/js/jquery.js"></script>
<dec:head />
</head>
<body>
	<div>
		<!-- /header -->
		<div id="m_header">
			<%@ include file="header.jsp"%>
		</div>

		<!-- /top menu -->
		<div id="m_menu_top">
			<%@ include file="menu-top.jsp"%>
		</div>

		<div id="m_container">
			<div id="content">
				<div class="row">
					<div class="col-sm-4"
						style="border-left: 1px solid #fff; min-height: 300px;">
						<%@ include file="sidebar.jsp"%>
					</div>
					<div class="col-sm-8">
						<dec:body />
					</div>
				</div>
			</div>
		</div>
		<!-- /main -->
		<div id="m_footer">
			<%@ include file="footer.jsp"%>
		</div>
		<!-- /footer -->
	</div>

</body>
</html>
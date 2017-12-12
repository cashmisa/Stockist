<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.report.supplierList" /></title>
</head>
<br />
<h3>
	<spring:message code="heading.report.supplierList" />
</h3>
<hr />
<a href="${pageContext.request.contextPath}/admin/report/all"><spring:message
		code="caption.reorderOverviewAll" /></a>
<br />
<c:if test="${supplierList.size() gt 0}">
<noscript><h6><br><strong><spring:message code="message.enableJavaScript" /></strong></h6></noscript>
	<br />
	<table id="supplierTable" class="tablesorter">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.supplierId" /></th>
				<th><spring:message code="fieldLabel.supplierName" /></th>
				<th><spring:message code="fieldLabel.contactName" /></th>
				<th><spring:message code="fieldLabel.phoneNo" /></th>
				<th><spring:message code="fieldLabel.email" /></th>
				<th><spring:message code="fieldLabel.website" /></th>
				<th><spring:message code="caption.reorderOverview" /></th>
				<th>PDF</th>
				<th>Email Report</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="supplier" items="${supplierList}">
				<tr class="listRecord">
					<td>${supplier.supplierId}</td>
					<td>${supplier.supplierName}</td>
					<td>${supplier.contactName}</td>
					<td>${supplier.phoneNumber}</td>
					<td>${supplier.email}</td>
					<td>${supplier.website}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/report/supplier/${supplier.supplierId}"><spring:message
								code="caption.reorderOverview" /></a></td>
					<td align="center"><a target="_blank"
						href="${pageContext.request.contextPath}/admin/report/supplierpdf/${supplier.supplierId}.pdf">PDF</a></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/mail/${supplier.supplierId}"><spring:message
								code="caption.placeOrder" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<div id="bottom_section">&nbsp;</div>

<script src="/js/jquery.tablesorter.js"></script>
<script>
	$(document).ready(function() {
		$("#supplierTable").tablesorter({
			widthFixed : true,
			widgets : [ 'zebra' ],
			headers : {
				6 : {
					sorter : false
				},

				7 : {
					sorter : false
				},
				
				8: {
					sorter : false
				}
			}
		});
	});
</script>

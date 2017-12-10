<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<br />
<h3>Supplier List for Reorder Report</h3>
<a href="${pageContext.request.contextPath}/admin/report/all"><spring:message
		code="caption.reorderReportAll" /></a><br/>
		<a href="${pageContext.request.contextPath}/admin/report/allpdf">view PDF report</a>
<c:if test="${supplierList.size() gt 0}">
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
				<th><spring:message code="caption.reorderReport" /></th>
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
						href="${pageContext.request.contextPath}/admin/report/supplier/${supplier.supplierId}.html"><spring:message
								code="caption.reorderReport" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<script src="/js/jquery.tablesorter.js"></script>
<script>
	$(document).ready(function() {
		$("#supplierTable").tablesorter({
			widthFixed : true,
			widgets : [ 'zebra' ]
		});
	});
</script>

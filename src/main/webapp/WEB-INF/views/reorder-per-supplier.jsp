<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<spring:message code="caption.reorderOverviewSupplier" />: ${supplierName }
</title>
</head>
<br />
<h3 align="center"><spring:message code="caption.reorderOverviewSupplier" />: ${supplierName }</h3>
<hr />
<p><a target="_blank"
						href="${pageContext.request.contextPath}/admin/report/supplierpdf/${supplierId}.pdf"><Strong><spring:message code="report.viewReport"></spring:message></Strong></a></p>
						<noscript><h6><br><strong><spring:message code="message.enableJavaScript" /></strong></h6></noscript>
<table id="reorder-table" class="tablesorter">
	<thead>
		<tr class="listHeading">
			<th align="center"><spring:message code="fieldLabel.partNumberReport" /></th>
			<th align="center"><spring:message code="fieldLabel.partPriceReport" /></th>
			<th align="center"><spring:message code="fieldLabel.partQtyReport" /></th>
			<th align="center"><spring:message code="fieldLabel.partROQReport" /></th>
			<th align="center"><spring:message code="fieldLabel.partMOQReport" /></th>
			<th align="center"><spring:message code="fieldLabel.orderQtyReport" /></th>
			<th align="center"><spring:message code="fieldLabel.orderPriceReport" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="reorder" items="${reorderList}">
			<tr class="listRecord">
				<td align="right"><fmt:formatNumber value="${reorder.key.partNumber}"
						pattern="##0000"></fmt:formatNumber></td>
				<td align="right"><fmt:formatNumber value="${reorder.key.price}"
						pattern="$#,##0.00"></fmt:formatNumber></td>
				<td align="right">${reorder.key.qty}</td>
				<td align="right">${reorder.key.reOrderQty}</td>
				<td align="right">${reorder.key.minOrderQty}</td>
				<td align="right">${reorder.value}</td>
				<td align="right"><fmt:formatNumber
						value="${reorder.key.price * reorder.value}" pattern="$#,##0.00"></fmt:formatNumber></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th align="right" id="total" colspan="6">TOTAL</th>
			<td align="right"><strong><fmt:formatNumber value="${sumPrice}"
						pattern="$#,##0.00"></fmt:formatNumber></strong></td>
		</tr>
	</tfoot>
</table>
<hr />
<p>
	<a href="${pageContext.request.contextPath }/admin/report/list"> <spring:message
			code="caption.back" /></a>
</p>
<div id="bottom_section">&nbsp;</div>
<script src="/js/jquery.tablesorter.js"></script>
<script>
	$(document).ready(function() {
		$("#reorder-table").tablesorter({
			widthFixed : true,
			widgets : [ 'zebra' ]
		});
	});
</script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.productList" /></title>
</head>
<br />
<h3>
	<spring:message code="heading.productList" />
</h3>
<hr />
<c:url var="add_url"
	value="${pageContext.request.contextPath}/admin/product/create" />
<a href="${add_url}"><spring:message code="caption.product.add" /></a>
<br />
<c:if test="${message != null}">
	<div class="alert alert-primary" style="color: black" role="alert">
		<h5>Great!</h5>
		<h6>${message}</h6>

	</div>
</c:if>
<br />
<c:if test="${fn:length(productList) gt 0}">
<noscript><h6><br><strong><spring:message code="message.enableJavaScript" /></strong></h6></noscript>
	<table id="productTable" class="tablesorter">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.partNumber" /></th>
				<th><spring:message code="fieldLabel.partName" /></th>
				<th><spring:message code="fieldLabel.partBrand" /></th>
				<th><spring:message code="fieldLabel.supplierName" /></th>
				<th><spring:message code="fieldLabel.partQty" /></th>
				<th style="width:30px"><spring:message code="fieldLabel.partMOQ" /></th>
				<th style="width:30px"><spring:message code="fieldLabel.partROQ" /></th>
				<th><spring:message code="fieldLabel.partPrice" /></th>
				<th><spring:message code="fieldLabel.partLocation" /></th>
				<th></th>
				<th></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productList}">
				<tr class="listRecord">
					<td>${product.partNumber}</td>
					<td>${product.partName}</td>
					<td>${product.brand}</td>
					<td>${product.supplier.supplierName}</td>
					<td>${product.qty}</td>
					<td>${product.minOrderQty}</td>
					<td>${product.reOrderQty}</td>
					<td><fmt:formatNumber type="currency" currencySymbol="$"
							value="${product.price}" /></td>
					<td>${product.shelfLocation}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/product/edit/${product.partNumber}"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/product/delete/${product.partNumber}"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<div id="bottom_section">&nbsp;</div>

<script src="/js/jquery.tablesorter.js"></script>
<script>
	$(document).ready(function() {
		$("#productTable").tablesorter({
			widgets : [ 'zebra' ],
			headers : {
				9 : {
					sorter : false
				},

				10 : {
					sorter : false
				}
			}
		});
	});
</script>
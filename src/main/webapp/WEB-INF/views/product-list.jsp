<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<script src="/js/jquery.tablesorter.js"></script>
<script>
	$(document).ready(function() {
		$("#productTable").tablesorter({
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

<br/><h3><spring:message code="heading.productList" /></h3>
<br>



<c:if test="${fn:length(productList) gt 0}">
	<table id="productTable" class="tablesorter">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.partNumber" /></th>
				<th><spring:message code="fieldLabel.partName" /></th>
				<th><spring:message code="fieldLabel.partBrand" /></th>
				<th><spring:message code="fieldLabel.supplierName" /></th>
				<th><spring:message code="fieldLabel.partQty" /></th>
				<th><spring:message code="fieldLabel.partMOQ" /></th>
				<th><spring:message code="fieldLabel.partROQ" /></th>
				<th><spring:message code="fieldLabel.partPrice" /></th>
				<th><spring:message code="fieldLabel.partLocation" /></th>
				<th> </th>
				<th> </th>

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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<script src="/js/jquery.tablesorter.js"></script>
<script>
	$(document).ready(function() {
		$("#productTable").tablesorter({
			widthFixed : true,
			widgets : [ 'zebra' ]
		});
	});
</script>


<form:form modelAttribute="emptyProductSearchDTO" method="post" action="${pageContext.request.contextPath}/catalogue">
	<h1><spring:message code="fieldLabel.productCatalogue" /></h1>
	<div>

		<table>

			<tr>
				<td><spring:message code="fieldLabel.partNumber" /></td>
				<td><form:input path="partNumber" type="number" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partName" /></td>
				<td><form:input path="partName" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partBrand" /></td>
				<td><form:input path="brand" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partLocation" /></td>
				<td><form:input path="shelfLocation" /></td>
			</tr>

			<tr id="tableButton">
				<td colspan="2"><form:button type="submit"> <spring:message code="fieldLabel.search" /> </form:button> 
				<a
					href="${pageContext.request.contextPath}/catalogue/all"><input type="button" value="<spring:message code="fieldLabel.browseAll" />"></input></a>
					 <a
					href="${pageContext.request.contextPath}/catalogue/reset"><input type="button" value="<spring:message code="fieldLabel.reset" />"></input></a></td>
			</tr>

		</table>
	</div>
	<br>

	<c:if test="${productList == null}">
		<h5>
			<spring:message code="fieldLabel.startSearch" />
		</h5>
	</c:if>

	<c:if test="${productList.size() == 0}">
		<h5>
			<spring:message code="fieldLabel.pleaseRefineSearch" />
		</h5>
	</c:if>

	<c:if test="${productList.size() > 0}">
		<%-- Display product info --%>
		<h5>
			<spring:message code="fieldLabel.showResult" arguments="${productList.size()};${productList.size()}" htmlEscape="false"
				argumentSeparator=";" />
		</h5>
		<br>
		<h6><strong>TIP!</strong> <spring:message code="fieldLabel.tip" /></h6>
		<table id="productTable" class="tablesorter">
			<thead>
				<tr>
					<th class="header"><spring:message code="fieldLabel.partNumber" /></th>
					<th class="header"><spring:message code="fieldLabel.partName" /></th>
					<th class="header"><spring:message code="fieldLabel.partBrand" /></th>
					<th class="header"><spring:message code="fieldLabel.partLocation" /></th>
					<th class="header"><spring:message code="fieldLabel.partQty" /></th>
				</tr>

			</thead>
			<tbody>
				<c:forEach var="product" items="${productList}">
					<tr>
						<c:url var="viewDetail" value="${pageContext.request.contextPath}/viewproduct/${product.partNumber}" />
						<td><a href="${viewDetail}">${product.partNumber}</a></td>
						<td>${product.partName}</td>
						<td>${product.brand}</td>
						<td>${product.shelfLocation}</td>
						<td>${product.qty}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</form:form>


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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<spring:message code="fieldLabel.productCatalogue" />
</title>
</head>
<form:form modelAttribute="productSearchDTO" method="post" action="${pageContext.request.contextPath}/catalogue">
	<br/><h3><spring:message code="fieldLabel.productCatalogue" /></h3>
	<div>

		<table class="searchTable">

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

			<tr>
				<td colspan="2" align="justify" id="tableButton"><form:button type="submit" class="btn btn-outline-primary" id="searchButton"> <spring:message code="button.search" /> </form:button> 
				<a
					href="${pageContext.request.contextPath}/catalogue/all"><input class="btn btn-outline-primary" id="browseAllButton" type="button" value="<spring:message code="button.browseAll" />"></input></a>
					 <a
					href="${pageContext.request.contextPath}/catalogue/reset"><input class="btn btn-outline-primary" id="resetButton" type="button" value="<spring:message code="button.reset" />"></input></a></td>
			</tr>

		</table>
	</div>
	<br>

	<c:if test="${productList == null}">
		<h6>
			<spring:message code="message.startSearch" />
			<br/>
			<spring:message code="message.browseAll" />
			<br/>
			<spring:message code="message.reset" />
		</h6>
	</c:if>

	<c:if test="${productList.size() == 0}">
		<h6>
			<spring:message code="message.pleaseRefineSearch" />
		</h6>
	</c:if>

	<c:if test="${productList.size() > 0}">
		<%-- Display product info --%>
		<h6>
			<spring:message code="message.showResult" arguments="${productList.size()};${productList.size()}" htmlEscape="false"
				argumentSeparator=";" />
		</h6>
		<br>
		<h6><strong>TIP!</strong> <spring:message code="message.tip" /></h6>
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


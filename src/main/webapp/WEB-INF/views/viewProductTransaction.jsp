
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="fieldLabel.viewProduct" /></title>
</head>


<form:form modelAttribute="transactionSearchHelper" method="post"
	action="${pageContext.request.contextPath}/viewproduct/${id}">
	<br/><h3>
		<spring:message code="fieldLabel.viewProduct" />
	</h3>
	<hr />
	<table class="tborder">
		<tr>
			<th><spring:message code="fieldLabel.partNumber" /></th>
			<td>${product.partNumber}</td>
		</tr>

		<tr>
			<th><spring:message code="fieldLabel.partName" /></th>
			<td>${product.partName}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partPrice" /></th>
			<td>${product.price}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partBrand" /></th>
			<td>${product.brand}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partQty" /></th>
			<td>${product.qty}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partMOQ" /></th>
			<td>${product.minOrderQty}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partROQ" /></th>
			<td>${product.reOrderQty}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partSupplier" /></th>
			<td>${product.supplier.supplierName}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partSupplierContact" /></th>
			<td>${product.supplier.contactName}</td>
		</tr>
		<tr>
			<th><spring:message code="fieldLabel.partLocation" /></th>
			<td>${product.shelfLocation}</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><div class="div-emptyspace"></div></td>
		</tr>
		<tr>
			<sec:authorize access="hasAuthority('admin')">
				<c:if test="${not empty product}">
					<td><a
						href="${pageContext.request.contextPath}/admin/product/edit/${product.partNumber}"
						class="btn btn-outline-primary txnButton" id="allButton"><spring:message
								code="caption.edit" /></a> <a
						href="${pageContext.request.contextPath}/admin/product/delete/${product.partNumber}"
						class="btn btn-outline-primary txnButton"><spring:message
								code="caption.delete" /></a></td>
				</c:if>

			</sec:authorize>
		</tr>
		<tr>
			<td><div class="div-emptyspace"></div></td>
		</tr>
	</table>
<br/>
	<c:if test="${createdRecord != null}">
	<div class="alert alert-primary" style="color:black" role="alert" id="createdRecord">
	<h5>Great!</h5>
	<h6>${createdRecord}</h6>
	</div>
	</c:if>
	<br>
	<h3>
		<spring:message code="heading.transaction" />
	</h3>
	<c:choose>
		<c:when test="${fn:length(transactionL) gt 0}">
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
				<tr>
					<td><div class="div-emptyspace"></div></td>
				</tr>
				<tr>
					<td colspan="2"><spring:message code="fieldLabel.startDate" />

						<form:input path="startDate" class="form-control" value=""
							id="example-date-input" type="date" name="startDateA" /></td>
					<td colspan="5"><spring:message code="fieldLabel.endDate" />
						<form:input path="endDate" class="form-control" value=""
							id="example-date-input" type="date" name="endDateA" /></td>
				</tr>
				<tr>
				<tr>
					<td></td>
					<td><form:errors path="startDate" cssStyle="color: red;" /></td>
					<td></td>
					<td><form:errors path="endDate" cssStyle="color: red;" /></td>
				</tr>
			</table>


			<c:choose>
				<c:when test="${fn:length(transactionList) gt 0}">
					<table id="productTable" class="tablesorter">
						<thead>
							<tr class="listHeading">
								<th><spring:message code="fieldLabel.transactionId" /></th>
								<th><spring:message code="fieldLabel.transactionDate" /></th>
								<th><spring:message code="fieldLabel.transactionCustomer" /></th>
								<th><spring:message code="fieldLabel.transactionQty" /></th>
								<th><spring:message code="fieldLabel.transactionType" /></th>
								<th><spring:message code="fieldLabel.transactionUser" /></th>
								<th><spring:message code="fieldLabel.transactionRemarks" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="transaction" items="${transactionList}">
								<tr class="listRecord">
									<td>${transaction.transactionId}</td>
									<td><fmt:formatDate type="both"
											value="${transaction.date}" /></td>
									<td>${transaction.customer}</td>
									<td>${transaction.qty}</td>
									<td>${transaction.transactionType}</td>
									<td>${transaction.user.userName}</td>
									<td>${transaction.remarks}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<tr>
						<td><h6>
								<spring:message code="Message.noTransactionFound" />
							</h6></td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td><div class="div-emptyspace"></div>
			<tr>
				<td colspan="2" align="left"><form:button type="submit"
						class="btn btn-outline-primary txnButton">
						<spring:message code="button.filter" />
					</form:button></td>
			</tr>
			<tr>
				<td><div class="div-smallemptyspace"></div></td>
			</tr>
		</c:when>
		<c:otherwise>
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
				<tr>
					<td><spring:message code="Message.noPreviousTransaction" /></td>
				</tr>
				<tr>
					<td><div class="div-emptyspace"></div></td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	<tr>
		<td><a href="${pageContext.request.contextPath}/catalogue/all"
			class="btn btn-outline-primary txnButton"><spring:message
					code="button.returnToCatalogue" /></a></td>
	</tr>
	<tr>
		<td><div class="div-smallemptyspace"></div></td>
	</tr>

	<tr>
		<sec:authorize access="hasAuthority('admin')">
			<td><a href="${pageContext.request.contextPath}/admin/product/"
				class="btn btn-outline-primary txnButton"><spring:message
						code="caption.adminProductPage" /></a></td>

		</sec:authorize>
	</tr>

</form:form>

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
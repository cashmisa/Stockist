<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "dd/mm/yyyy"
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "dd/mm/yyyyy"
		});
	});
</script>

<form:form method="post"
	action="${pageContext.request.contextPath}/viewproduct/${id}">
	<h3>
		<spring:message code="fieldLabel.viewProduct" />
	</h3>
			<table>
				<tr>
					<td><spring:message code="fieldLabel.partNumber" /></td>
					<td>${product.partNumber}</td>
				</tr>

				<tr>
					<td><spring:message code="fieldLabel.partName" /></td>
					<td>${product.partName}</td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.partPrice" /></td>
					<td>${product.price}</td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.partBrand" /></td>
					<td>${product.brand}</td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.partQty" /></td>
					<td>${product.qty}</td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.partMOQ" /></td>
					<td>${product.minOrderQty}</td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.partROQ" /></td>
					<td>${product.reOrderQty}</td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.partSupplier" /></td>
					<td>${product.supplier}</td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.partLocation" /></td>
					<td>${product.shelfLocation}</td>
				</tr>
			</table>
	<br>
	<br>
	<c:if test="${fn:length(transactionList) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tr>
				<td><spring:message code="fieldLabel.startDate" /></td>
				<td><form:input size="16" path="fromDate" id="datepicker1"
						name="startDate" /> <form:errors path="fromDate"
						cssStyle="color: red;" /></td>
				<td><spring:message code="fieldLabel.endDate" /></td>
				<td><form:input size="16" path="toDate" id="datepicker2"
						name="endDate" /> <form:errors path="toDate"
						cssStyle="color: red;" /></td>
			</tr>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.transactionId" /></th>
				<th><spring:message code="fieldLabel.transactionDate" /></th>
				<th><spring:message code="fieldLabel.transactionCustomer" /></th>
				<th><spring:message code="fieldLabel.transactionQty" /></th>
				<th><spring:message code="fieldLabel.transactionType" /></th>
				<th><spring:message code="fieldLabel.transactionUser" /></th>
				<th><spring:message code="fieldLabel.transactionRemarks" /></th>
			</tr>
			<c:forEach var="transaction" items="${transactionList}">
				<tr class="listRecord">
					<td>${transaction.TransactionId}</td>
					<td>${transaction.Date}</td>
					<td>${transaction.Customer}</td>
					<td>${transaction.Qty}</td>
					<td>${transaction.TransactionType}</td>
					<td>${transaction.User}</td>
					<td>${transaction.Remarks}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2" align="left"><br></br> <form:button
						type="submit">
						<img
							src="${pageContext.request.contextPath}/image/button_submit.gif"
							alt="" align="middle">
					</form:button></td>
			</tr>
		</table>
	</c:if>
</form:form>

</html>
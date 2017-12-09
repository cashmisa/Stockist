<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<form:form modelAttribute="transactionSearchHelper" method="post"
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
			<td>${product.supplier.contactName}</td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.partLocation" /></td>
			<td>${product.shelfLocation}</td>
		</tr>
	</table>

	<br>
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<c:choose>
			<c:when test="${fn:length(transactionL) gt 0}">

				<tr>
					<td><spring:message code="fieldLabel.startDate" /></td>

					<td><form:input path="startDate" class="form-control" value=""
							id="example-date-input" type="date" name="startDateA" /></td>
					<td><spring:message code="fieldLabel.endDate" /></td>
					<td><form:input path="endDate" class="form-control" value=""
							id="example-date-input" type="date" name="endDateA" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:errors path="startDate" cssStyle="color: red;" /></td>
					<td></td>
					<td><form:errors path="endDate" cssStyle="color: red;" /></td>
				</tr>



				<c:choose>
					<c:when test="${fn:length(transactionList) gt 0}">

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
								<td>${transaction.transactionId}</td>
								<td>${transaction.date}</td>
								<td>${transaction.customer}</td>
								<td>${transaction.qty}</td>
								<td>${transaction.transactionType}</td>
								<td>${transaction.user.userName}</td>
								<td>${transaction.remarks}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td><spring:message code="Message.noTransactionFound" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="2" align="left"><br></br> <form:button
							type="submit" class="btn btn-outline-primary">
							<spring:message code="button.filter" />
						</form:button></td>
				</tr>

			</c:when>
			<c:otherwise>
				<tr>
					<td><spring:message code="Message.noPreviousTransaction" /></td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr><td><a href="${pageContext.request.contextPath}/catalogue"
			class="btn btn-outline-primary"><spring:message
				code="button.returnToCatalogue" /></a></td></tr>

	</table>
</form:form>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<html>
<head>
<title><spring:message code="heading.product.editProduct" /></title>
</head>
<br />
<h3>
	<spring:message code="heading.product.editProduct" />
</h3><hr/>
<form:form method="POST" modelAttribute="productDTO"
	action="${pageContext.request.contextPath}/admin/product/edit/${productDTO.partNumber}">
	<table class="searchTable">
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.partNumber" /></td>
				<td><form:input cssStyle="color:#868e96;opacity:1"
						path="partNumber" readonly="true" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partName" /></td>
				<td><form:input path="partName" /></td>
				<td><form:errors path="partName" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partBrand" /></td>
				<td><form:input path="brand" /></td>
				<td><form:errors path="brand" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.supplier" /></td>
				<td><form:select path="supplierId" itemValue="supplierId"
						items="${suppliersList}" itemLabel="supplierName">
					</form:select></td>
				<td><a
					href="${pageContext.request.contextPath}/admin/supplier/create"><spring:message
							code="heading.supplier.addSupplier" /></a></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partQty" /></td>
				<td><form:input path="qty" min="0" type="number" /></td>
				<td><form:errors path="qty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partMOQ" /></td>
				<td><form:input path="minOrderQty" min="1" type="number" /></td>
				<td><form:errors path="minOrderQty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partROQ" /></td>
				<td><form:input path="reOrderQty" min="1" type="number" /></td>
				<td><form:errors path="reOrderQty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partPrice" /></td>
				<td><span class="input-group-btn">$</span> <form:input
						path="price" type="number" min="0.1" step="0.01" /></td>
				<td><form:errors path="price" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partLocation" /></td>
				<td><form:input path="shelfLocation" /></td>
				<td><form:errors path="shelfLocation" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td colspan="2"><form:button type="submit"
						class="btn btn-outline-primary" id="allButton">
						<spring:message code="button.saveChanges" />
					</form:button> <form:button type="button" class="btn btn-outline-primary"
						onclick="location.href='${pageContext.request.contextPath}/admin/product/list'">
						<spring:message code="button.cancel" />
					</form:button></td>
			</tr>
		</tbody>
	</table>
</form:form>
</html>

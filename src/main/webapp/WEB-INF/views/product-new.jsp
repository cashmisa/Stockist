<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.product.addProduct" /></title>
</head>
<br />
<h3>
	<spring:message code="heading.product.addProduct" />
</h3>
<hr />
<form:form method="POST" modelAttribute="productDTO"
	action="${pageContext.request.contextPath}/admin/product/create">
	<table class="searchTable">
		<tbody>
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
				<td><spring:message code="fieldLabel.supplierName" /></td>
				<td><form:select path="supplierId">
						<form:options items="${suppliersList}" itemValue="supplierId"
							itemLabel="supplierName" />
					</form:select></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partQty" /></td>
				<td><form:input type="number" min="0" path="qty" /></td>
				<td><form:errors path="qty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partMOQ" /></td>
				<td><form:input type="number" min="1" path="minOrderQty" /></td>
				<td><form:errors path="minOrderQty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partROQ" /></td>
				<td><form:input type="number" min="1" path="reOrderQty" /></td>
				<td><form:errors path="reOrderQty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partPrice" /></td>
				<td>$<form:input type="number" min="0.1" step="0.01"
						path="price" /></td>
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
						<spring:message code="button.addNew" />
					</form:button> <a href="${pageContext.request.contextPath}/admin/product"
					class="btn btn-outline-primary"><spring:message
							code="button.cancel" /></a></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Product page</h3>
<form:form method="POST" modelAttribute="productDTO"
	action="${pageContext.request.contextPath}/admin/product/create">
	<table>
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
				<td><form:input type="number" path="qty" /></td>
				<td><form:errors path="qty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partMOQ" /></td>
				<td><form:input type="number" path="minOrderQty" /></td>
				<td><form:errors path="minOrderQty" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partROQ" /></td>
				<td><form:input type="number" path="reOrderQty" /></td>
				<td><form:errors path="reOrderQty" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.partPrice" /></td>
				<td>$<form:input type="number" path="price" /></td>
				<td><form:errors path="price" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.partLocation" /></td>
				<td><form:input path="shelfLocation" /></td>
				<td><form:errors path="shelfLocation" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Product page</h3>
<form:form method="POST" modelAttribute="product"
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
				<td><form:input path="Brand" /></td>
				<td><form:errors path="Brand" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.supplierId" /></td>
				<td><form:input path="supplier" /></td>
				<td><form:errors path="supplier" cssStyle="color: red;" /></td>
			</tr>

		   <tr>
				<td><spring:message code="fieldLabel.partQty" /></td>
				<td><form:input path="Quantity"/></td>
				<td><form:errors path="Quantity" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.partMOQ" /></td>
				<td><form:input path="minOrderQty"/></td>
				<td><form:errors path="minOrderQty" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.partROQ" /></td>
				<td><form:input path="reOrderQty"/></td>
				<td><form:errors path="reOrderQty" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.partPrice" /></td>
				<td><form:input path="price	"/></td>
				<td><form:errors path="price" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.partLocation" /></td>
				<td><form:input path="shelfLocation"/></td>
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


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Supplier page</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/product/create">
	<table>
		<tbody>
			
			<tr>
				<td><spring:message code="fieldLabel.partName" /></td>
				<td><form:input path="partName" /></td>
				<td><form:errors path="partName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.brand" /></td>
				<td><form:input path="brand" /></td>
				<td><form:errors path="brand" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.supplierId" /></td>
				<td><form:input path="supplierId" /></td>
				<td><form:errors path="supplierId" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.qty" /></td>
				<td><form:input path="qty"/></td>
				<td><form:errors path="qty" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.minOrderQty" /></td>
				<td><form:input path="minOrderQty"/></td>
				<td><form:errors path="minOrderQty" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.reOrderQty" /></td>
				<td><form:input path="reOrderQty"/></td>
				<td><form:errors path="reOrderQty" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.price	" /></td>
				<td><form:input path="price	"/></td>
				<td><form:errors path="price" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.shelfLocation" /></td>
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


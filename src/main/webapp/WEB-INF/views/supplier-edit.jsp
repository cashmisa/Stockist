<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Supplier page</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/supplier/edit/${supplier.supplierId}">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.supplierId" /></td>
				<td><form:input path="supplierId" readonly="true" /></td>
				
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.supplierName" /></td>
				<td><form:input path="supplierName" /></td>
				<td><form:errors path="supplierName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.contactName" /></td>
				<td><form:input path="contactName" /></td>
				<td><form:errors path="contactName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.phoneNo" /></td>
				<td><form:input path="phoneNumber" /></td>
				<td><form:errors path="phoneNumber" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.email" /></td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.website" /></td>
				<td><form:input path="website"/></td>
				<td><form:errors path="website" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Update" />
				</td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<html>
<head>
<title>
<spring:message code="heading.user.editUser" />
</title>
</head>
<h3><spring:message code="heading.product.editProduct" /></h3>
<form:form method="POST" modelAttribute="productDTO"
	action="${pageContext.request.contextPath}/admin/product/edit/${productDTO.partNumber}">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.partNumber" /></td>
				<td><form:input path="partNumber" readonly="true"/></td>
				<td><form:errors path="partNumber" cssStyle="color: red;" /></td>
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
				<td><spring:message code="fieldLabel.partPrice" /></td>
				<td>$<form:input path="price" /></td>
				<td><form:errors path="price" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.partQty" /></td>
				<td><form:input path="qty"/></td>
				<td><form:errors path="qty" cssStyle="color: red;" /></td>
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
				<td><spring:message code="fieldLabel.supplierId" /></td>
				<td><form:select path="supplierId">				
				<form:options items="${suppliersList}" selected="${productDTO.supplierId}"/>
				</form:select></td>
<%-- 				<td><form:errors path="supplier" cssStyle="color: red;" /></td> --%>
			</tr>
			
			<tr>
				<td><spring:message code="fieldLabel.partLocation" /></td>
				<td><form:input path="shelfLocation"/></td>
				<td><form:errors path="shelfLocation" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><form:button type="submit" class="btn btn-outline-primary" id="allButton"><spring:message code="button.saveChanges" /></form:button>
				<form:button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/admin/product/list'"><spring:message code="button.cancel" /></form:button>
				</td>
			</tr>
		</tbody>
	</table>
</form:form>
</html>

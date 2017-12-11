<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.transaction.create"/></title>
</head>
<body>
<h3><spring:message code="heading.transaction.create"/></h3><hr/>
<form:form method="POST" modelAttribute="transaction" action="${pageContext.request.contextPath}/usage/create">
	<table>
	        <tr>
				<td><spring:message code="fieldLabel.partNumber" /></td>
				<td><input type="number" name="partNumber"> ${producterrorMsg} </td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionQty" /></td>
				<td><form:input path="qty" type="number" /> ${qtyerrorMsg}</td>
				<td><form:errors path="qty" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionType" /></td>
				<td><form:select path="transactionType" items="${typelist}"/>
				<td><form:errors path="transactionType" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.transactionCustomer" /></td>
				<td><form:input path="customer" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionRemarks" /></td>
				<td><form:input path="remarks" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:button type="submit"> Create New Record </form:button></td>
				<td></td>
			</tr>
			
			
	</table>
</form:form>
</body>
</html>
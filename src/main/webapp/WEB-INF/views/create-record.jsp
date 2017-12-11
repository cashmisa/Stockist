<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create Record page</h1>
<form:form method="POST" modelAttribute="transaction" action="${pageContext.request.contextPath}/usage/create">
	<table>
	        <tr>
				<td><spring:message code="fieldLabel.partNumber" /></td>
				<td><input type="number" name="partNumber"> ${errorMsg} </td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionQty" /></td>
				<td><form:input path="qty" type="number" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionType" /></td>
				<td><form:select path="transactionType" items="${typelist}"/>
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
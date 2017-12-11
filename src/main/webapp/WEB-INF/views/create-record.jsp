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
<form:form method="POST" modelAttribute="transaction" action="${pageContext.request.contextPath}/admin/transaction/create">
	<table>
	        <tr>
				<td>Part Number:</td>
				<td><input type="text" name="partNumber"></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><form:input path="qty" /></td>
			</tr>
			<tr>
				<td>Transaction Type:</td>
				<td><form:input path="transactionType" /></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><form:password path="date" /></td>
			</tr>
			<tr>
				<td>Customer:</td>
				<td><form:password path="customer" /></td>
			</tr>
			<tr>
				<td>Remark:</td>
				<td><form:password path="remarks" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:button type="submit"> Create New Record </form:button></td>
				<td></td>
			</tr>
	</table>
</form:form>
</body>
</html>
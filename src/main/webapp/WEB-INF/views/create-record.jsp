<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
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
				<td><spring:message code="fieldLabel.partNumber" /></td>
				<td><input type="text" name="partNumber"></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionQty" /></td>
				<td><form:input path="qty" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldlabel.transactionType" /></td>
				<td><form:input path="transactionType" /></td>
			</tr>
			<tr>
			    <td colspan="2"><spring:message code="fieldLabel.transactionDate" />

						<form:input path="date" class="form-control" value=""
							id="example-date-input" type="date" name="date" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionCustomer" /></td>
				<td><form:password path="customer" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionRemarks" /></td>
				<td><form:password path="remarks" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:button type="submit"> Create New Record </form:button></td>
				<td></td>
			</tr>
			
			<c:set scope="request" var="userName" value="<sec:authentication property="principal.username" />"/>
			
			
	</table>
</form:form>
</body>
</html>
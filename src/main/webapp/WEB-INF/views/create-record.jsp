<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.usage"/></title>
<br/><h3><spring:message code="heading.usage"/></h3><hr/>
<form:form method="POST" modelAttribute="transaction" action="${pageContext.request.contextPath}/usage/create">
	<table class="searchTable">
	        <tr>
				<td><spring:message code="fieldLabel.partNumber" /></td>
				<td><input type="number" name="partNumber"></td>
				<td><font color="red"> ${producterrorMsg} </font></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.transactionQty" /></td>
				<td><form:input path="qty" type="number" /></td>
				<td><form:errors path="qty" cssStyle="color: red;" /></td>
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
				<td colspan="2"><form:button type="submit" class="btn btn-outline-primary" id="allButton"><spring:message code="button.addNew" /></form:button>
				<form:button type="button" class="btn btn-outline-primary" onclick="location.href='${pageContext.request.contextPath}/catalogue/all'"><spring:message code="button.cancel" /></form:button></td>
				<td></td>
			</tr>		
	</table>
</form:form>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Catalogue</title>

<style type="text/css">
table {
	text-align: left;
}

tr {
	padding: 1px 1px;
}
</style>
</head>
<body>
	<form:form modelAttribute="emptyProductSearchDTO" method="post" action="${pageContext.request.contextPath}/catalogue">
		<h1>Product Catalogue</h1>
		<div>

			<table>

				<tr>
					<td>Part Number:</td>
					<td><form:input path="partNumber" type="number" /></td>
				</tr>

				<tr>
					<td>Part Name:</td>
					<td><form:input path="partName" /></td>
				</tr>

				<tr>
					<td>Brand:</td>
					<td><form:input path="brand" /></td>
				</tr>

				<tr>
					<td>Shelf:</td>
					<td><form:input path="shelfLocation" /></td>
				</tr>

				<tr>
					<td colspan="2"><form:button type="submit"> Search </form:button> <a
						href="${pageContext.request.contextPath}/catalogue/all"><input type="button" value="Browse All"></input></a> <a
						href="${pageContext.request.contextPath}/catalogue/reset"><input type="button" value="Reset"></input></a></td>
				</tr>

			</table>
		</div>
		<br>

		<c:if test="${productList == null}">
			<h3>>>> Click search button to browse catalogue</h3>
		</c:if>

		<c:if test="${productList.size() == 0}">
			<h3>>>> No result found. Please refine your search</h3>
		</c:if>


		<c:if test="${productList.size() > 0}">
			<%-- Display product info --%>
			<h3>>>> Showing ${productList.size()}/${productList.size()} result(s)</h3>
			<br>
			<table>
				<thead>
					<tr>
						<th>Part Number</th>
						<th>Part Name</th>
						<th>Brand</th>
						<th>Shelf</th>
						<th>Stock</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="product" items="${productList}">
						<tr>
							<c:url var="viewDetail" value="${pageContext.request.contextPath}/viewproduct/${product.partNumber}" />
							<td><a href="${viewDetail}">${product.partNumber}</a></td>
							<td>${product.partName}</td>
							<td>${product.brand}</td>
							<td>${product.shelfLocation}</td>
							<td>${product.qty}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</form:form>
</body>
</html>
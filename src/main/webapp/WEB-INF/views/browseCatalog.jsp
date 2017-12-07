<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="emptyProduct" method="post">
	<h1>Browse Catalog</h1>
	Part Number: <form:input path="partNumber"/>
	Part Name: <form:input path="partName"/>
	Brand: <form:input path="brand"/>
	<form:button type="submit"> Search </form:button>
	
	<%-- Display product info --%>
	<ul>
		<c:forEach var="product" items="${productList}">
			<li>Part Number: ${product.partNumber}</li>
			<li>Part Name: ${product.partName}</li>
			<li>Brand: ${product.brand}</li>
			
			<c:url var="productDetail" value="${pageContext.request.contextPath}/viewproduct/${product.partNumber}"></c:url>	
			<li><a href="${productDetail}">View Product Detail</a></li>
			<br>
		</c:forEach>
	</ul>
	
</form:form>
</body>
</html>
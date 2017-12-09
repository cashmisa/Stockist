<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h3><spring:message code="heading.supplier.supplierList" /></h3>

<style>

 table th {
    
    background-color: #007bff;
    color: white;
}

</style>
<br>

<a href="${pageContext.request.contextPath}/admin/supplier/create">Add Supplier</a>
<br>
	<br>
	
	
	<c:if test="${message != null}">
	<div class="alert alert-primary" style="color:black" role="alert">
  <h4 class="alert-heading">Success !!!</h4>
 ${message}

</div>
</c:if>

	<c:if test="${errorMessage != null}">
	<div class="alert alert-primary" style="color:red"  role="alert">
  <h4 class="alert-heading" style="color:red" >Exception!!!</h4>
 ${errorMessage}
 
</div>
</c:if>
	
	<br> 
<c:if test="${fn:length(supplierList) gt 0}">
<div class="container table-responsive">
	<table class="table table-bordered table-hover" id="supplier-table">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.supplierId" /></th>
				<th><spring:message code="fieldLabel.supplierName" /></th>
				<th><spring:message code="fieldLabel.contactName" /></th>
				<th><spring:message code="fieldLabel.phoneNo" /></th>
				<th><spring:message code="fieldLabel.email" /></th>
				<th><spring:message code="fieldLabel.website" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="supplier" items="${supplierList}">
				<tr class="listRecord">
					<td>${supplier.supplierId}</td>
					<td>${supplier.supplierName}</td>
					<td>${supplier.contactName}</td>
					<td>${supplier.phoneNumber}</td>
					<td>${supplier.email}</td>
					<td>${supplier.website}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/supplier/edit/${supplier.supplierId}"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/supplier/delete/${supplier.supplierId}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</c:if>
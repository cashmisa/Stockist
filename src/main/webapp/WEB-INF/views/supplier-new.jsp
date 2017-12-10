<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
<spring:message code="heading.supplier.addSupplier" />
</title>
</head>

<script>
$(document).ready(function() {
$( "#target1" ).keypress(function() {
	$("#error1").html("");
});
$( "#target2" ).keypress(function() {
	$("#error2").html("");
});
$( "#target3" ).keypress(function() {
	$("#error3").html("");
});
$( "#target4" ).keypress(function() {
	$("#error4").html("");
});
$( "#target5" ).keypress(function() {
	$("#error5").html("");
});
});

</script>
<br/><h3><spring:message code="heading.supplier.addSupplier" /></h3>


<div class="col-md-4">
	<form:form method="POST" modelAttribute="supplier" action="${pageContext.request.contextPath}/admin/supplier/create">


		<div class="form-group">

			<spring:message code="fieldLabel.supplierName" />
			<form:input id="target1" path="supplierName" class="form-control" />
			<form:errors id="error1" path="supplierName" cssStyle="color: red;" />


		</div>
		<div class="form-group">
			<spring:message code="fieldLabel.contactName" />
			<form:input id="target2" path="contactName" class="form-control target" />
			<form:errors id="error2" path="contactName" cssStyle="color: red;" />
		</div>
		<div class="form-group">
			<spring:message code="fieldLabel.phoneNo" />
			<form:input id="target3" path="phoneNumber"  class="form-control target" />
			<form:errors id="error3" path="phoneNumber" cssStyle="color: red;" />
		</div>
		<div class="form-group">
			<spring:message code="fieldLabel.email" />
			<form:input id="target4" path="email" class="form-control target" />
			<form:errors id="error4" path="email" cssStyle="color: red;" />
		</div>

		<div class="form-group">
			<spring:message code="fieldLabel.website" />
			<form:input id="target5" path="website" class="form-control target" />
			<form:errors id="error5" path="website" cssStyle="color: red;" />
	
	</div>
		<div class="container">
			<button class="btn btn-primary" type="submit" >Create</button>
			
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/supplier">
			Cancel
			</a> 
		
		</div>
		
		
		
		
		

		
		
		
			
</form:form>
</div>



<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/tablesorter-style.css" type="text/css">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="heading.supplier.editSupplier" />
</title>
</head>
<br />
<h3>
	<spring:message code="heading.supplier.editSupplier" />
</h3>
<hr />

<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/supplier/edit/${supplier.supplierId}">
	<table class="searchTable">
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.supplierId" /></td>
				<td><form:input path="supplierId" readonly="true" cssStyle="color:#868e96;opacity:1" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.supplierName" /></td>
				<td><form:input id="target1" path="supplierName"
						class="form-control" /></td>
				<td><form:errors id="error1" path="supplierName"
						cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.contactName" /></td>
				<td><form:input id="target2" path="contactName"
						class="form-control target" /></td>
				<td><form:errors id="error2" path="contactName"
						cssStyle="color: red;" /></td>
			<tr>
				<td><spring:message code="fieldLabel.phoneNo" /></td>
				<td><form:input id="target3" path="phoneNumber"
						class="form-control target" /></td>
				<td><form:errors id="error3" path="phoneNumber"
						cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.email" /></td>
				<td><form:input id="target4" path="email"
						class="form-control target" /></td>
				<td><form:errors id="error4" path="email"
						cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><spring:message code="fieldLabel.website" /></td>
				<td><form:input id="target5" path="website"
						class="form-control target" /></td>
				<td><form:errors id="error5" path="website"
						cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td colspan="2"><form:button type="submit"
						class="btn btn-outline-primary" id="allButton">
						<spring:message code="button.saveChanges" />
					</form:button> <a href="${pageContext.request.contextPath}/admin/supplier"
					class="btn btn-outline-primary"> <spring:message
							code="button.cancel" /></a></td>
			</tr>
		</tbody>
	</table>
</form:form>


<script>
	$(document).ready(function() {
		$("#target1").keypress(function() {
			$("#error1").html("");
		});
		$("#target2").keypress(function() {
			$("#error2").html("");
		});
		$("#target3").keypress(function() {
			$("#error3").html("");
		});
		$("#target4").keypress(function() {
			$("#error4").html("");
		});
		$("#target5").keypress(function() {
			$("#error5").html("");
		});
	});
</script>


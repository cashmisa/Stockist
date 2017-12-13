<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style>
#thumbwrap span {
	position: absolute;
	visibility: hidden;
}

#thumbwrap:hover, #thumbwrap:hover span {
	visibility: visible;
	top: 0;
	left: 250px;
	z-index: 1;
}
</style>
<div class="card" style="position: fixed">

	<nav id="sidebar">
		<!-- Sidebar Links -->
		<div class="list-group list-group-flush">
			<a class="list-group-item list-group-item-action" href="/catalogue"><spring:message
					code="sidebar.catalogue" /></a> <a
				class="list-group-item list-group-item-action" href="/usage"><spring:message
					code="sidebar.usage" /></a>
			<sec:authorize access="hasAnyAuthority('admin')">
				<a class="list-group-item list-group-item-action"
					href="/admin/product/"><spring:message code="sidebar.product" /></a>
				<a class="list-group-item list-group-item-action"
					href="/admin/supplier/"><spring:message code="sidebar.supplier" /></a>
				<a class="list-group-item list-group-item-action" href="/admin/user"><spring:message
						code="sidebar.user" /></a>
				<a class="list-group-item list-group-item-action"
					href="/admin/report"><spring:message code="sidebar.report" /></a>
			</sec:authorize>
			<img src="/images/ThuongDe1.png" width="132" height="77" alt="">
			<img src="/images/Stockist_logo.jpg" width="177" height="83" alt="">
			<a id="thumbwrap" href="https://www.facebook.com/matrixhero259"><img
				src="/images/ffacebook.png" width="177" height="55" alt=""></a>
					<h6><spring:message code="page.footer" /></h6>
		</div>
		
	</nav>

</div>

<script type="text/javascript">
	$(function() {
		// this will get the full URL at the address bar
		var url = window.location.href;

		// passes on every "a" tag
		$(".list-group a").each(function() {
			var url = window.location.href;
			// checks if its the same on the address bar
			if (url.includes(this.href)) {
				$(this).addClass("active");
			}
		});
	});
</script>
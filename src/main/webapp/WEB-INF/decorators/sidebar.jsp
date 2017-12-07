<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<div class="card">

	<nav id="sidebar">
		<!-- Sidebar Links -->
		<div class="list-group list-group-flush">
			<a class="list-group-item list-group-item-action" href="/viewproduct/">View Products</a>
			<a class="list-group-item list-group-item-action" href="/catalog">Catalog</a>
			<a class="list-group-item list-group-item-action" href="/usage">Record usage</a>
			<sec:authorize access="hasAnyAuthority('admin')">
				<a class="list-group-item list-group-item-action" href="/admin/product/">Products</a>
				<a class="list-group-item list-group-item-action" href="/admin/supplier">Suppliers</a>
				<a class="list-group-item list-group-item-action" href="/admin/user">User</a>
				<a class="list-group-item list-group-item-action" href="/admin/report">Report</a>
			</sec:authorize>
		</div>
	</nav>

</div>
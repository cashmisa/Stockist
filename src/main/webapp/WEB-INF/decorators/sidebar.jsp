<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
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

<div class="card">

	<nav id="sidebar">
		<!-- Sidebar Links -->
		<div class="list-group list-group-flush">
			<a class="list-group-item list-group-item-action" href="/catalogue">Catalogue</a>
			<a class="list-group-item list-group-item-action" href="/usage">Record usage</a>
			<sec:authorize access="hasAnyAuthority('admin')">
				<a class="list-group-item list-group-item-action" href="/admin/product/">Products</a>
				<a class="list-group-item list-group-item-action" href="/admin/supplier/">Suppliers</a>
				<a class="list-group-item list-group-item-action" href="/admin/user">User</a>
				<a class="list-group-item list-group-item-action" href="/admin/report">Report</a>
			</sec:authorize>
		</div>
	</nav>

</div>
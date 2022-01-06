<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- Navbar -->
	<nav class="navbar navbar-dark bg-dark"
		aria-label="First navbar example">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">Wanna Be JavaEE</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarsExample01"
				aria-controls="navbarsExample01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExample01">
				<ul class="navbar-nav me-auto mb-2">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/swagger-ui/index.html">Swagger - UI</a></li>
					<li class="nav-item"><a class="nav-link" href="/v3/api-docs">Docs JSON</a></li>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>

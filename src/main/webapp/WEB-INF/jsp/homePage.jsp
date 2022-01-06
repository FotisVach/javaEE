<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Wanna Be JavaEE</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>

<body>
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
	<div class="main">
		<!-- Display User Name and Role -->
		<h1 align="center">WannaBe java EE</h1>
		<div class="p-5 mb-4 bg-light rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">Custom jumbotron</h1>
				<p class="col-md-8 fs-4">Using a series of utilities, you can
					create this jumbotron, just like the one in previous versions of
					Bootstrap. Check out the examples below for how you can remix and
					restyle it to your liking.</p>
				<button class="btn btn-primary btn-lg" type="button">Example
					button</button>
			</div>
		</div>
	</div>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>
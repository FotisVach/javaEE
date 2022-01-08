<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Error Page</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<!-- Navbar -->
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="main">
		<!-- Display Books -->
		<div class="px-5 mb-4 bg-light rounded-3">
			<div class="container-fluid py-5">

				<div class="card mt-4">
					<h1 class="card-title text-center text-danger">Error Page:</h1>
					<div class="card-body">
						<h2 class="shadow p-3 mb-4 border rounded-3 border-danger">Error Status code:
							${ERROR_STATUS_CODE}</h2>
						<h4 class="shadow p-3 mb-4 border rounded-3 border-danger">Request failed: 
							'${ERROR_REQUEST_URI}'</h4>
						<h4 class="shadow p-3 mb-4 border rounded-3 border-danger text-danger">Exception:
							${ERROR_EXCEPTION}</h4>

					</div>


				</div>

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
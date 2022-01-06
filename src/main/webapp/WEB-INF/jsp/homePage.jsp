<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<!-- Navbar -->
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="main">
		<!-- Display Books -->
		<div class="px-5 mb-4 bg-light rounded-3">
			<div class="container-fluid py-5">

				<!-- Check for logout -->
				<c:if test="${deletedFlag}">
					<div class="alert alert-success" role="alert">Book deleted
						successfully</div>
				</c:if>

				<h1 class="display-5 fw-bold">Available Books</h1>
				<p class="col-md-8 fs-4">Showing available Books from the store</p>

				<div class="bd-example">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Book Title</th>
								<th scope="col">Book Author</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<!-- Loop over and print our books -->
							<c:forEach var="tempBook" items="${books}">
								<!-- Construct an update link with book id -->
								<c:url var="updateLink" value="showBookPage">
									<c:param name="bookId" value="${tempBook.id}" />
								</c:url>
								<!-- Construct an delete link with book id -->
								<c:url var="deleteLink" value="/deleteBook">
									<c:param name="bookId" value="${tempBook.id}" />
								</c:url>
								<tr>
									<th scope="row">${tempBook.id}</th>
									<td>${tempBook.title}</td>
									<td>${tempBook.author}</td>
									<td class="text-end"><a class="btn btn-primary btn-sm"
										href="${updateLink }">Show Book info</a> <a
										class="btn btn-danger btn-sm" href="${deleteLink }"
										onclick="if (!(confirm('Are you sure you want to delete this Book?'))) return false">Delete
											Book</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<a class="btn btn-primary btn-lg" href="/addBook">Create Book</a>
				<!-- <button class="btn btn-primary btn-lg" type="button">Create Book</button> -->
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

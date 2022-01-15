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
	<!-- Navbar -->
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="main">
		<!-- Display Books -->
		<div class="px-5 mb-4 bg-light rounded-3">
			<div class="container-fluid py-5">

				<div class="card mt-4">
					<h2 class="card-title text-center text-primary">Book Info:</h2>
					<div class="card-body">
						<form:form action="addBook" modelAttribute="book" method="POST">
							<!-- We neew to associate this data with book id -->
							<form:hidden path="id" />
							<div class="form-group row">
								<label for="title" class="col-form-label">Book Title :</label>
								<div class="col">
									<input type="text" class="form-control" id="title" name="title"
										placeholder="${book.title}">
								</div>
							</div>
							<div class="form-group row">
								<label for="author" class="col-form-label">Book author :</label>
								<div class="col">
									<input type="text" class="form-control" id="author"
										name="author" placeholder="${book.author}">
								</div>
							</div>
							<div class="form-group row">
								<label for="description" class="col-form-label">Book
									description :</label>
								<div class="col">
									<textarea class="form-control" id="description"
										name="description" placeholder="${book.description}"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="unitCost" class="col-form-label">Book
									unitCost :</label>
								<div class="col">
									<input type="number" class="form-control" id="unitCost"
										name="unitCost" placeholder="${book.unitCost}">
								</div>
							</div>
							<div class="form-group row">
								<label for="isbn" class="col-form-label">Book isbn :</label>
								<div class="col">
									<input type="text" class="form-control" id="isbn" name="isbn"
										placeholder="${book.isbn}">
								</div>
							</div>
							<div class="form-group row">
								<label for="publicationDate" class="col-form-label">Book
									publicationDate :</label>
								<div class="col">
									<input type="date" class="form-control" id="publicationDate"
										name="publicationDate" value="${book.publicationDate}">
								</div>
							</div>
							<div class="form-group row">
								<label for="numberOfPages" class="col-form-label">Book
									numberOfPages :</label>
								<div class="col">
									<input type="number" class="form-control" id="numberOfPages"
										name="numberOfPages" placeholder="${book.numberOfPages}">
								</div>
							</div>
							<div class="form-group row">
								<label for="imageUrl" class="col-form-label">Book
									imageUrl :</label>
								<div class="col">
									<input type="text" class="form-control" id="imageUrl"
										name="imageUrl" placeholder="${book.imageUrl}">
								</div>
							</div>
							<div class="form-group row">
								<label for="language" class="col-form-label">Book
									language :</label>
								<div class="col">
									<form:select
										class="btn btn-light btn-outline-secondary dropdown-toggle"
										items="${allLanguages}" path="language" id="language"
										name="language" />
								</div>
							</div>
							<input class="my-3 btn btn-primary btn" type="submit"
								value="Save" />
							<a class="my-3 btn btn-secondary btn" href="/home">Return to
								home Page</a>
						</form:form>
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

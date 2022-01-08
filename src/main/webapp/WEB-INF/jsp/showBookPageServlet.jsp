<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="com.javaee.fotis.po.Book" %>

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
		<div class="px-5 bg-light rounded-3">
			<div class="container-fluid py-5">

				<div class="card">
					<h2 class="m-4 card-title text-center text-primary">Book Info:</h2>
					<div class="card-body">
						<form:form>
							<fieldset disabled>
							<% Book book = (Book) request.getAttribute("book"); %>
								<table>
									<tr>
										<th scope="row">Book Title :</th>
										<td><div class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getTitle() %></div></td>
									</tr>
									
									<tr>
										<th scope="row">Book author :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getAuthor() %></label></td>
									</tr>
									<tr>
										<th scope="row">Book description :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getDescription() %></label></td>
									</tr>
									<tr>
										<th scope="row">Book unitCost :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getUnitCost() %></label></td>
									</tr>
									<tr>
										<th scope="row">Book isbn :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getIsbn() %></label></td>
									</tr>
									<tr>
										<th scope="row">Book publicationDate :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getPublicationDate() %></label></td>
									</tr>
									<tr>
										<th scope="row">Book numberOfPages :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getNumberOfPages() %></label></td>
									</tr>
									<tr>
										<th scope="row">Book imageUrl :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getImageUrl() %></label></td>
									</tr>
									<tr>
										<th scope="row">Book language :</th>
										<td><label class="shadow p-3 m-2 border rounded-3 border-primary d-flex flex-column"><%= book.getLanguage() %></label></td>
									</tr>
								
								</table>
							</fieldset>
						</form:form>
						<a class="my-3 btn btn-primary btn-sm" href="/home">Return to
							home Page</a>
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

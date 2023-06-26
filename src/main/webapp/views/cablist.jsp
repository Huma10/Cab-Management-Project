<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<h1 class="text-center fw-bold">Cab List</h1>
	<sf:form method="post" action="/cab" modelAttribute="cab">
	<div class="container text-center">
	<a class="text-center btn btn-outline-danger mt-4 mb-3" href="<c:url value="/cab"/>">Add Cab</a>
	<c:if test="${success!=null}">
		<div class="alert alert-primary fw-bold text-dark" role="alert">
  				${success}
		</div>
	</c:if>
	<c:if test="${error!=null}">
		<div class="alert alert-danger fw-bold text-dark" role="alert">
  				${error}
		</div>
	</c:if>
		<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Sr No.</th>
				<th>Cab Registration Number</th>
				<th>Cab Model</th>
				<th>Cab Colour</th>
				<th>Action</th>
			</tr>
		</thead>	
			<tbody>
					<c:forEach items="${list}" var="c" varStatus="idx">
					<tr>
						<td>${idx.index + 1}</td>
						<td>${c.cabRegistrationNumber}</td>
						<td>${c.cabModel}</td>
						<td>${c.cabColour}</td>
						<td>
							<a href="/cab?id=${c.id}" class="btn btn-warning fw-bold text-dark">Update</a>
							<a href="/cabs?id=${c.id}" class="btn btn-danger fw-bold text-dark">Delete</a>
						</td>
						</tr>
					</c:forEach>
					
			</tbody>
		</table>
	</div>	
	</sf:form>
</body>
</html>
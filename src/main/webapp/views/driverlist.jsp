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
	<h1 class="text-center fw-bold">Driver List</h1>
	
	<sf:form method="post" action="/add" modelAttribute="driver">
	<div class="container text-center">
	<a class="text-center btn btn-outline-danger mt-4 mb-3" href="<c:url value="/add"/>">Add Driver</a>
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
				<th>Driver Id Number</th>
				<th>Driver Name</th>
				<th>Driver Email</th>
				<th>Phone No</th>
				<th>Action</th>
			</tr>
		</thead>	
			<tbody>
					<c:forEach items="${list}" var="d" varStatus="idx">
					<tr>
						<td>${idx.index + 1}</td>
						<td>${d.driverIdNumber}</td>
						<td>${d.driverName}</td>
						<td>${d.email}</td>
						<td>${d.phoneNo}</td>
						<td>
							<a href="/add?id=${d.id}" class="btn btn-warning fw-bold text-dark">Update</a>
							<a href="/list?id=${d.id}" class="btn btn-danger fw-bold text-dark">Delete</a>
						</td>
						</tr>
					</c:forEach>
					
			</tbody>
		</table>
	</div>	
	</sf:form>
</body>
</html>
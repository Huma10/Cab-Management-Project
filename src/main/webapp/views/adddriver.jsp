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
	<h1 class="text-center fw-bold">Driver Page</h1>
	<sf:form method="post" action="/add" modelAttribute="driver">
	<sf:hidden path="id"/>
	<sf:hidden path="driverIdNumber"/>
	<div class="container">
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
		<table class="table table-striped table-bordered">
			<tr>
				<td><label class="form-label fw-bold">Driver Name</label></td>
				<td>
					<s:bind path="driverName">
									<sf:input path="${status.expression}"
										placeholder="Enter Driver Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
					</s:bind>
				</td>
			</tr>
			<tr>
				<td><label class="form-label fw-bold">Email</label></td>
				<td>
					<s:bind path="email">
									<sf:input path="${status.expression}"
										placeholder="Enter Email" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
					</s:bind>
				</td>
			</tr>
			<tr>
				<td><label class="form-label fw-bold">Phone Number</label></td>
				<td>
					<s:bind path="phoneNo">
									<sf:input path="${status.expression}"
										placeholder="Enter Phone Number" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
					</s:bind>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
				<c:if test="${driver.getId()!=null }">
				<input type="submit" value="Update Driver" class="btn btn-warning fw-bold text-dark">
				</c:if>
				<c:if test="${driver.getId()==null }">
					<input type="submit" value="Add Driver" class="btn btn-warning fw-bold text-dark">
				</c:if>
				</td>
			</tr>
		</table>
	</div>	
	</sf:form>
</body>
</html>
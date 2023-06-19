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
	<h1 class="text-center fw-bold">Cab Page</h1>
	<sf:form method="post" action="/cab" modelAttribute="cab">
	<sf:hidden path="id"/>
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
				<td><label class="form-label fw-bold">Cab Registration Number</label></td>
				<td>
					<s:bind path="cabRegistrationNumber">
									<sf:input path="${status.expression}"
										placeholder="Enter Cab Registration Number" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
					</s:bind>
				</td>
			</tr>
			<tr>
				<td><label class="form-label fw-bold">Cab Model</label></td>
				<td>
					<s:bind path="cabModel">
									<sf:input path="${status.expression}"
										placeholder="Enter Cab Model" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
					</s:bind>
				</td>
			</tr>
			<tr>
				<td><label class="form-label fw-bold">Cab Colour</label></td>
				<td>
					<s:bind path="cabColour">
									<sf:input path="${status.expression}"
										placeholder="Enter Cab Colour" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
					</s:bind>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
				<c:if test="${driver.getId()!=null }">
				<input type="submit" value="Update Cab" class="btn btn-warning fw-bold text-dark">
				</c:if>
				<c:if test="${driver.getId()==null }">
					<input type="submit" value="Add Cab" class="btn btn-warning fw-bold text-dark">
				</c:if>
				</td>
			</tr>
		</table>
	</div>	
	</sf:form>
</body>
</html>
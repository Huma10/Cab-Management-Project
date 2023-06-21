<%@page import="com.cabmanagement.controller.DriverController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Home Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger text-white fw-bold">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Cab Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/list">Driver List</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="<c:url value="/add"/>">Add Driver</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/cabs">Cab List</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="<c:url value="/cab"/>">Add Cab</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="<c:url value="/driverlist"/>">Driver</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="<c:url value="/cab"/>">Cab</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	
	
</body>
</html>
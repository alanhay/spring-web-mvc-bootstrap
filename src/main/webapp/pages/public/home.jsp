<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Application Home</title>
</head>
<body>
	<div class="hero-unit">
	  <h1>Welcome</h1>
	  <br/>
	  <p>Spring MVC, Spring WebFLow, Spring Data and Spring Security Sample Application</p>
	  <br/>
	  <p>
			<sec:authorize access="! isAuthenticated()">
		    <a class="btn btn-primary btn-large" href="public/loadLogin.do">
		     	Login
		    </a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
		    <a class="btn btn-primary btn-large">
		     	Do Stuff
		    </a>
		</sec:authorize>
	  </p>
	</div>
</body>
</html>
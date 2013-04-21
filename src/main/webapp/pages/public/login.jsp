<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Authentication</title>
</head>
<body>
	<form action="j_spring_security_check" method="post">
		<fieldset>
			<legend>Login</legend>

			<c:if test="${param.error == 'true'}">
				<div class="alert alert-error">Invalid Username or Password.
					Please try again.</div>
			</c:if>

			<div class="control-group">
				<label class="control-label" path="emailAddress">Email
					Address</label>
				<div class="controls">
					<div class="input-prepend">
						<span class="add-on"><i class="icon-user"></i></span> 
						<input type="text" placeHolder="Email Address" name="j_username"
							autocomplete="false" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" path="password">Password</label>
				<div class="controls">
					<div class="input-prepend">
						<span class="add-on"><i class="icon-lock"></i></span> 
						<input type="password" placeHolder="Password" name="j_password" 
							autocomplete="false"/>
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Submit</button>
				</div>
			</div>
		</fieldset>
	</form>
	<a href="public/resetPassword.do">Request New Password</a>
</body>
</html>
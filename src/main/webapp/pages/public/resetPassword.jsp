<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Change Password</title>
</head>
<body>
	<form:form modelAttribute="resetPasswordForm" action="public/resetPassword.do" method="post">
		<fieldset>
			<legend>Reset Password</legend>
			
			<t:input path="emailAddress" label="Email Address"/>
			
			<div class="control-group">
				<div class="controls">
					<button type="cancel" class="btn">Cancel</button>
					<button type="submit" class="btn">Submit</button>
				</div>
			</div>
		</fieldset>
	</form:form>
</body>
</html>
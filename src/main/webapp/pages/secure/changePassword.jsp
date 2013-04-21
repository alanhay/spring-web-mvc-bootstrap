<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Change Password</title>
</head>
<body>
	<form:form modelAttribute="passwordForm" action="secure/changePassword.do" method="post">
		<fieldset>
			<legend>Change Password</legend>
			
			<t:input path="password" password="true" label="Password"/>
			<t:input path="passwordConfirmation" password="true" label="Confirm Password"/>
			
			<div class="control-group">
				<div class="controls">
					<button type="cancel" class="btn">Cancel</button>
					<button type="submit" class="btn">Submit</button>
				</div>
			</div>
		</fieldset>
	</form:form>
	
	<script>
		$('input[type=password]:enabled:first').focus();
	</script>
		
</body>
</html>
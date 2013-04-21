<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Change Password</title>
</head>
<body>
	<form:form modelAttribute="passwordForm" method="post">
		<fieldset>
			<legend>Step 2</legend>
			<div class="control-group">
				<div class="controls">
					<input type="submit" name="_eventId_cancel" value="Cancel" /> <input
						type="submit" name="_eventId_proceed" value="Proceed" />
				</div>
			</div>
		</fieldset>
	</form:form>

</body>
</html>
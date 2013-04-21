<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Details</title>
</head>
<body>
	<form:form class="form-horizontal" modelAttribute="user">
		<fieldset>
			<legend>${legend}</legend>
			
			<t:input path="forename" label="Forename" placeHolder="Forename" required="true" cssClass="input-large"/>
			<t:input path="surname" label="Surname" placeHolder="Surname" required="true" cssClass="input-large" />
			<t:input path="emailAddress" label="Email Address" placeHolder="Email Address" required="true" />
			<t:input path="address.lineOne" label="Address Line 1" placeHolder="Address 1" required="true"/>
			<t:input path="address.lineTwo" label="Address Line 2"/>
			<t:input path="address.town" label="Town" placeHolder="Town" required="true" cssClass="input-large"/>
			<t:input path="address.postCode" label="Post Code" placeHolder="Post Code" required="true" cssClass="input-medium"/>
			<t:input path="phoneNumber" label="Phone Number" placeHolder="Phone Number" required="true" cssClass="input-medium"/>
			<t:radioGroup items="${genders}" path="gender" label="Gender" itemLabel="name"/>
		
			<t:date path="dateOfBirth" label="Date Of Birth" initialDate="${user.dateOfBirth}" required="true" />
			
			<c:if test="${! editMode}">
				<t:input path="password" label="Password" password="true" placeHolder="Password" required="true" cssClass="input-medium" />
				<t:input path="passwordConfirmation" label="Confirm Password" password="true" placeHolder="Password" required="true" cssClass="input-medium" />
			</c:if>
			
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Submit</button>
				</div>
			</div>
			
			<c:if test="${editMode}">
				<input type="hidden" name="userId" value="${user.id}"/>
			</c:if>
		</fieldset>
	</form:form>
	
	<script>
		$('#datepicker').datepicker();
	</script>
</body>
</html>
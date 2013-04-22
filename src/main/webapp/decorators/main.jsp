<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><decorator:title /></title>
	<base href="<%=basePath%>" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
	<link href="css/datepicker.css" rel="stylesheet" media="screen" />
	<link href="css/styles.css" rel="stylesheet" media="screen" />
	
	<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-dropdown.js"></script>
	<script src="js/jquery-displaytag-ajax-1.2.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script> 
</head>
<body>
	<div class="container">
		<div class="row-fluid">

			<div class="navbar" style="margin-top: 50px;">
				<div class="navbar-inner">
					<a class="brand" href="#"></a>
					<ul class="nav">
						<li class="${tabName =='Home' ? 'active' : ''}">
							<spring:url value="/public/loadHome.do" var="url"/>
							<a href="${url}">Home</a>
						</li>
						<sec:authorize access="! isAuthenticated()">
							<li class="${tabName =='Register' ? 'active' : ''}">
							<spring:url value="/public/register.do" var="url"/>
							<a href="${url}">Register</a>
						</li>
						</sec:authorize>
						<sec:authorize access="! isAuthenticated()">
							<li class="${tabName =='Login' ? 'active' : ''}">
								<spring:url value="/public/loadLogin.do" var="url"/>
								<a href="${url}">Login</a>
							</li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
							<li class="${tabName =='Secure' ? 'active' : ''}">
								<spring:url value="/secure/loadSecure.do" var="url"/>
								<a href="${url}">Secure</a>
							</li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${tabName =='Admin' ? 'active' : ''}">
								<spring:url value="/secure/admin/loadAdmin.do" var="url"/>
								<a href="${url}">Admin</a>
							</li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
							<li class="dropdown ${tabName =='MyAccount' ? 'active' : ''}">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account</a>
								<ul class="dropdown-menu">
									<li>
										<spring:url value="/secure/editMyDetails.do" var="url"/>
										<a tabindex="-1" href="${url}">My Details</a>
										<spring:url value="/secure/changePassword.do" var="url"/>
										<a tabindex="-1" href="${url}">Change Password</a>
									</li>	
	 							</ul>
 							</li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
							<li><a href="j_spring_security_logout">Logout</a></li>
						</sec:authorize>
					</ul>
				</div>
			</div>

			<div class="row-fluid">
				<decorator:body />
			</div>
		</div>
		<script>
			$(document).ready(function() {
				
				/**AUTO SELECT FIRST TEXT INPUT ON ANY PAGE**/
				$('input[type=text]:enabled:first').focus();
				
				/*REGISTER A GLOBAL AJAX HANDLER FOR SESSION TIMEOUT*/
				$(function () {
				    //setup ajax error handling
				    $.ajaxSetup({
				        error: function (x, status, error) {
				            if (x.status == 403) {
				                //alert("Sorry, your session has expired. Please login again to continue");
				                window.location.reload();
				            }
				            else {
				                alert("An error occurred: " + status + "\nError: " + error);
				            }
				        }
				    });
				});
			});
		</script>
	</div>
</body>
</html>
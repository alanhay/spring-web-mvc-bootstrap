<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User List</title>

</head>
<body>
	<h3>Active Users</h3>
	<br />

<!-- 	<div class="accordion" id="accordian">
		<div class="accordion-group">
			<div class="accordion-heading">
			<a class="btn btn-info" data-toggle="collapse" style="margin:3px;margin-left:5px;"
				data-target="#collapseOne"><i class="icon-search icon-white"></i> Filter Data</a>
			</div>
			<div id="collapseOne" class="accordion-body collapse">
				<div class="accordion-inner"> -->
				<div class="well well-small">
					<!-- <legend>Filter Users</legend> -->
					<form:form id="filterForm" class="form-inline" modelAttribute="filterForm" action="secure/admin/filterUsers.do" method="get">
						<form:input id="filterSurnameField" path="surname" placeHolder="Surname"
							class="input-small" autocomplete="off" />
						<form:input id="filterLocationField" path="location" placeHolder="Location"
							class="input-medium" autocomplete="off" />
						<input type="hidden" name="page.sort" value="surname, forename" />
						<input type="hidden" name="page.sort.dir" value="asc" />
						<button type="submit" class="btn" name="action" value="applyFilter">Filter</button>
						<button id="clearFilter" type="submit" class="btn" name="action" value="clearFilter">Clear</button>
					</form:form>
				</div>
<!-- 				</div>
			</div>
		</div>
	</div> -->

	<div id="displayTagDiv">
		<%@ include file="./fragments/userTable.jsp" %>
	</div>
	
	<script>
		$(document).ready(function() {
 			$(function() {
				$("#displayTagDiv").displayTagAjax();
			}); 

 			 $('#filterForm').ajaxForm({
				target: '#displayTagDiv',
 			
				success: function() { 
					$("#displayTagDiv").displayTagAjax();
					
					$("a[rel=popover]").popover({html:true}).click(function(e) { 
				        e.preventDefault(); 
				    }); 
					
					$('input[type=text]:enabled:first').focus();
		        } 
			});  
			
			$("a[rel=popover]").popover({html:true}).click(function(e) { 
		        e.preventDefault(); 
		    });  
 			
 			$('#collapseOne').on('shown', function () {
 				$('input[type=text]:enabled:first').focus();
 			});
 			
 			$("#clearFilter").click(function(event) {
 				$("#filterForm").resetForm();
 			});
 			
 			 $("#filterSurnameField").typeahead({
 		        minLength: 1,
 		        source: function(query, process) {
 		            $.post('secure/admin/getUniqueUserSurnames.do', { q: query, limit: 8 }, function(data) {
 		                process(data);
 		            });
 		        }
 		    });
 			 
 			 $("#filterLocationField").typeahead({
  		        minLength: 1,
  		        source: function(query, process) {
  		            $.post('secure/admin/getUniqueUserLocations.do', { q: query, limit: 8 }, function(data) {
  		                process(data);
  		            });
  		        }
  		    });
		});
	</script>
	
</body>
</html>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${param.action eq 'applyFilter'}">
		<c:set var="excludedParams" value="" />
	</c:when>
	<c:otherwise>
		<c:set var="excludedParams" value="surname location action" />
	</c:otherwise>
</c:choose>

<display:table name="users" id="userTable"
	excludedParams="${excludedParams}"
	class="table table-striped table-condensed table-bordered table-hover"
	sort="external" requestURI="secure/admin/listUsers.do"
	decorator="uk.co.certait.spring.web.table.UserTableDecorator">
	<display:column property="name" title="Name" style="width:19%" />
	<display:column property="address.town" title="Location" style="width:16%" />
	<display:column property="emailAddress" title="Email" style="width:25%" />
	<display:column property="phoneNumber" title="Phone" style="width:20%" />
	<display:column property="fullDetails" title="Info" style="width:10%" />
	<display:column property="editLink" title="Edit" style="width:10%"/>
</display:table>

<%--
 * edit.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="pencil/reviewer/edit.do" modelAttribute="pencil458">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="description375">
		<spring:message code="pencil458.description375" />:
	</form:label>
	<form:input path="description375" />
	<form:errors cssClass="error" path="description375" />
	<br />
	<br />

	<form:label path="anniversary866">
		<spring:message code="pencil458.description375" />:
	</form:label>
	<form:input path="anniversary866" />
	<form:errors cssClass="error" path="anniversary866" />
	<br />
	<br />

	<form:label path="weight343">
		<spring:message code="pencil458.weight343" />:
	</form:label>
	<form:input path="weight343" />
	<form:errors cssClass="error" path="weight343" />
	<br />
	<br />
	
	<form:label path="birthdate045">
		<spring:message code="pencil458.birthdate045" />:
	</form:label>
	<form:input path="birthdate045" />
	<form:errors cssClass="error" path="birthdate045" />
	<br />
	<br />

	
	<%-- <form:errors cssClass="error" path="reviewer" /> --%>
	<br />

	<input type="submit" name="save"
		value="<spring:message code="pencil458.save" />" />&nbsp; 
	<input type="button" name="cancel"
		value="<spring:message code="pencil458.cancel" />"
		onclick="javascript: relativeRedir('pencil/reviewer/list.do');" />
	<br />

</form:form>

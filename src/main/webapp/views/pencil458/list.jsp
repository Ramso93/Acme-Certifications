<%--
 * list.jsp
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

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="pencil458s" requestURI="${requestURI}" id="row">
	
	<!-- Attributes -->
	
	<spring:message code="pencil458.description375" var="description375Header" />
	<display:column property="description375" title="${description375Header}" sortable="false" />

	<spring:message code="pencil458.anniversary866" var="anniversary866Header" />
	<display:column property="anniversary866" title="${anniversary866Header}" sortable="true" format="{0,date,dd/MM/yyyy}" />

	<spring:message code="pencil458.weight343" var="weight343Header" />
	<display:column property="weight343" title="${weight343Header}" sortable="false" />
	
	<spring:message code="pencil458.birthdate045" var="birthdate045Header" />
	<display:column property="birthdate045" title="${birthdate045Header}" sortable="true" format="{0,date,dd/MM/yyyy}" />
	
	
	<!-- Action links -->

	<security:authorize access="hasRole('REVIEWER')">
		<display:column>
			<a href="pencil/reviewer/edit.do?pencil458Id=${row.id}">
				<spring:message	code="pencil458.edit" />
			</a>
		</display:column>		
	</security:authorize>
	
</display:table>
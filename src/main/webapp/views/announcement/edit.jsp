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

<form:form action="announcement/administrator/edit.do" modelAttribute="announcement">

	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="title">
		<spring:message code="announcement.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />

	<form:label path="moment">
		<spring:message code="announcement.moment" />:
	</form:label>
	<form:input path="moment" />
	<form:errors cssClass="error" path="moment" />
	<br />

	<form:label path="description">
		<spring:message code="announcement.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />

	<form:label path="certification">
		<spring:message code="announcement.certification" />:
	</form:label>
	<form:select id="certifications" path="certification" onchange="javascript: reloadExams()">
		<form:option value="0" label="----" />		
		<form:options items="${certifications}" itemValue="id"
			itemLabel="title" />
	</form:select>
	<form:errors cssClass="error" path="certification" />

	<form:label path="exam">
		<spring:message code="announcement.exam" />:
	</form:label>
	<form:select id="exams" path="exam">
		<form:option value="0" label="----" />		
		<form:options items="${exams}" itemValue="id" itemLabel="title" />
	</form:select>
	<form:errors cssClass="error" path="exam" />
	<br />
	
	<form:label path="reviewer">
		<spring:message code="announcement.reviewer" />:
	</form:label>
	<form:select id="reviewers" path="reviewer">
		<form:option value="0" label="----" />		
		<form:options items="${reviewers}" itemValue="id" itemLabel="name" />
	</form:select>
	<%-- <form:errors cssClass="error" path="reviewer" /> --%>
	<br />

	<input type="submit" name="save"
		value="<spring:message code="announcement.save" />" />&nbsp; 
	<jstl:if test="${announcement.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="announcement.delete" />"
			onclick="return confirm('<spring:message code="announcement.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<input type="button" name="cancel"
		value="<spring:message code="announcement.cancel" />"
		onclick="javascript: relativeRedir('announcement/administrator/list.do');" />
	<br />

	<script type="text/javascript">
		function reloadExams() {
			var certificationId = $('select#certifications').val();
			var placeholder = $('select#exams');

			placeholder.load("exam/findByCertificationId.do?certificationId=" + certificationId);			
		}
	</script>

</form:form>

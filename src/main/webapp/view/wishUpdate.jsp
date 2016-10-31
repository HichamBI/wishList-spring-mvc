<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<form:form method="post" modelAttribute="wishCreationForm" action="updateWish">
    <form:input type="hidden" path="id"/>
    <spring:message code="common.label"/>
    <form:input path="label"/>
    <b><i><form:errors path="label" cssclass="error"/></i></b><br>
    <spring:message code="common.quantity"/>
    <form:input path="quantity"/>
    <b><i><form:errors path="quantity" cssclass="error"/></i></b><br>
    <input type="submit"/>
</form:form>

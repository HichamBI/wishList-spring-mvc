<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<form:form method="post" modelAttribute="wishCreationForm" action="addWish">
    <spring:message code="common.label"/>
    <form:input path="label"/>
    <b><i><form:errors path="label" cssclass="error"/></i></b><br>
    <spring:message code="common.quantity"/>
    <form:input path="quantity"/>
    <b><i><form:errors path="quantity" cssclass="error"/></i></b><br>
    <input type="submit"/>
</form:form>
<table border="1">
    <thead>
    <tr>
        <th><spring:message code="common.id"/></th>
        <th><spring:message code="common.label"/></th>
        <th><spring:message code="common.quantity"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${wishList}" var="list">
        <tr>
            <td><c:out value="${list.id}"/></td>
            <td><c:out value="${list.label}"/></td>
            <td><c:out value="${list.quantity}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

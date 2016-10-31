<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<table border="1">
    <thead>
    <tr>
        <th><spring:message code="common.id"/></th>
        <th><spring:message code="common.label"/></th>
        <th><spring:message code="common.quantity"/></th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${wishList}" var="list">
        <tr>
            <td><c:out value="${list.id}"/></td>
            <td><c:out value="${list.label}"/></td>
            <td><c:out value="${list.quantity}"/></td>
            <td>
                <c:url value="/removeWish" var="url">
                    <c:param name="wishId" value="${list.id}"/>
                </c:url>
                <a href="${url}">
                    <spring:message code="common.remove"/>
                </a>
            </td>
            <td>
                <c:url value="/wishUpdate" var="url">
                    <c:param name="wishId" value="${list.id}"/>
                </c:url>
                <a href="${url}">
                    <spring:message code="common.update"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

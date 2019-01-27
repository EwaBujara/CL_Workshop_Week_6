<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">

<table class="table table-striped table-dark">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <c:if test="${currentUser.username != user.username}">
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><a class="btn btn-info" href="/show-solutions?exerciseId=${exercise.id}">Send message</a></td>
        </tr>
        </c:if>
    </c:forEach>
</table>
</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>

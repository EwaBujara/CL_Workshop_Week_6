<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">
<c:if test="${currentUser != null}">
<table class="table table-striped table-dark">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Location</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
            <tr>
                <td>${currentUser.username}</td>
                <td>${currentUser.email}</td>
                <td>${currentUser.location}</td>
                <td>${currentUser.description}</td>
                <td><a class="btn btn-info" href="/show-solutions?exerciseId=${exercise.id}">Edit</a>
                <a class="btn btn-info" href="/show-solutions?exerciseId=${exercise.id}">Delete</a></td>
            </tr>
</table>
</c:if>
<c:if test="${currentUser == null}">
    <div class="p-3 mb-2 bg-dark text-white">
        <h3>You have no access!</h3>
    </div>
</c:if>
</body>
</html>

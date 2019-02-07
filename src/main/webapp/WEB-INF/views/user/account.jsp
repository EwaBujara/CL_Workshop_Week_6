<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">

<c:if test="${currentUser == null}">
    <div class="p-3 mb-2 bg-light text-dark">
        <h3 class="text-center">You have no access!</h3>
        <p class="text-center">You must sign in</p>
    </div>
</c:if>

<c:if test="${currentUser != null}">
<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Meows</th>
        <th>Localisation</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-dark" href="http://localhost:8080/meow/list/${user.id}">${user.meows.size()}</a></td>
                <td>${user.localisation}</td>
                <td>${user.description}</td>
                <td>
                    <c:if test="${user.id}">
                    <a class="btn btn-dark" href="http://localhost:8080/user/edit/${user.id}">Edit</a>
                        <a class="btn btn-dark" href="http://localhost:8080/user/delete/${user.id}">Delete</a>
                    </c:if>
                    <a class="btn btn-dark" href="http://localhost:8080/user/delete/${user.id}">Send message</a>

                </td>

            </tr>
</table>
</c:if>
</body>
</html>
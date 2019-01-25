<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>Users:</h1>
<a href="${pageContext.request.contextPath}/user/add">Add New User</a>
<ul>
    <c:forEach items="${users}" var="user">
        <li>
            <h2>${user.firstName} ${user.lastName}</h2>
            <p>
                <a href="${pageContext.request.contextPath}/user/add/${author.id}">Edit</a>|
                <a href="${pageContext.request.contextPath}/user/delete/${author.id}">Delete</a>
            </p>
        </li>
    </c:forEach>
</ul>
</body>
</html>

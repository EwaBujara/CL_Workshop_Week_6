<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meows List</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">
<table class="table table-striped table-dark">
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Created</th>
        <th>Content</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${meows}" var="meow">
            <tr>
                <td>${meow.title}</td>
                <td>${meow.user.username}</td>
                <td>${meow.created}</td>
                <%--<td>${meow.meowText}</td>--%>
                <td>${fn:substring(meow.meowText, 0, 40)}</td>
                <td><a class="btn btn-info" href="http://localhost:8080/meow/meow/${meow.id}">See more</a></td>
            </tr>
        
    </c:forEach>
</table>
</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meows List</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">
<ul>
    <c:forEach items="${meows}" var="meow">
        <li>
            <h2>${meow.title} ${meow.meowText}</h2>
        </li>
    </c:forEach>
</ul>
</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>

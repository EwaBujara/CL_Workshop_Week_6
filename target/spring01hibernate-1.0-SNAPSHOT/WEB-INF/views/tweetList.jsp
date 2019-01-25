<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet List</title>
</head>
<body>
<ul>
    <c:forEach items="${tweets}" var="tweet">
        <li>
            <h2>${tweet.title} ${tweet.tweetText}</h2>
        </li>
    </c:forEach>
</ul>
</body>
</html>

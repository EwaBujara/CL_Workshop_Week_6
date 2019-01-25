<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fom" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body>

    <form:hidden path="id" />

    <form:form method="post"
           action="${pageContext.request.contextPath}/tweet/save"
           modelAttribute="tweet"
           cssClass="container col-6" >

    <form:select path="user">
        <form:options items="${users}"
                      itemValue="id"
                      itemLabel="lastName" />
    </form:select>
    <form:errors path="user"/>

    <form:input path="title" placeholder="Title" cssClass="form-input"/>
    <form:errors path="title" cssClass="alert alert-danger" element="div"/>

    <form:input path="tweetText" placeholder="Tweet Text" cssClass="form-input"/>
    <form:errors path="tweetText" cssClass="alert alert-danger" element="div"/>

    <input type="submit"  class="btn btn-success">
</form:form>

</body>
</html>

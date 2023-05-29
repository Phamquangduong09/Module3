<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/29/2023
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${brand}" var="b">
    <tr>
        <td>${b.id}</td>
        <td>${b.name}</td>
        <td><button onclick="deleteS(${b.id})">Delete</button></td>
        <td><a href="brand?action=update&&id=${b.id}">Update</a></td>
    </tr>
    </c:forEach>
</table>
</body>
<script>
    function deleteS(id) {
        if (confirm("Are you sure?")) {
            window.location.href = `http://localhost:8080/brand?action=delete&&id=` + id
        }
    }
</script>
</html>

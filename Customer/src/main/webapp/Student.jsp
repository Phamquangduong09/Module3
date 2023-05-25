<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/25/2023
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="2px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach var="i" items="${listStudent}">
        <tr>
            <th><c:out value="${i.id}"></c:out><br></th>
            <th><c:out value="${i.name}"></c:out></th>
            <th><c:out value="${i.age}"></c:out></th>
        </tr>
    </c:forEach>
</table>
<button name="add" type="submit"><a href="Create.jsp">CREATE</a></button>
</body>
</html>

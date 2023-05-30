<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/29/2023
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Form create student</h1>
<form style="width: 600px; margin: auto" action="/products?action=create" method="post">
    <input type="text" name="name" placeholder="Enter name">
    <input type="text" name="price" placeholder="Enter price">
    <select name="brandId">
        <c:forEach var="b" items="${brand}">
            <option value="${b.id}">
                    ${b.name}
            </option>
        </c:forEach>
    </select>
    <input type="text" name="color" placeholder="Enter color">
    <input type="text" name="describe" placeholder="Enter describe">
    <input type="date" name="date">
    <button type="submit">Create</button>
    <a  href="/products">Back to home</a>
</form>
</body>
</html>

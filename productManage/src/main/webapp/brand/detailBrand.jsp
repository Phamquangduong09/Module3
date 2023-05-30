
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/29/2023
  Time: 9:28 PM
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
    <th>Price</th>
    <th>Brand</th>
    <th>Color</th>
    <th>Describe</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${product}" var="p">
  <c:if test="${p.brand.name==brand}">
  <tr>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>${p.price}</td>
    <td>${p.brand.name}</td>
    <td>${p.color}</td>
    <td>${p.describe}</td>
    <td>${sum}</td>
  </tr>
  </c:if>
  </c:forEach>
</table>
</body>
</html>

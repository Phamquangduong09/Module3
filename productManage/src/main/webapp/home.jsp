<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="/products?action=create">Creat new product</a>
<a href="/brand">Action brand</a>
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
    <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>${p.brand.name}</td>
        <td>${p.color}</td>
        <td>${p.describe}</td>
        <td><button onclick="deleteS(${p.id})">Delete</button></td>
        <td><a href="products?action=update&&id=${p.id}">Update</a></td>
    </tr>
    </c:forEach>
</table>
</body>
<script>
    function deleteS(id) {
        if (confirm("Are you sure?")) {
            window.location.href = `http://localhost:8080/products?action=delete&&id=` + id
        }
    }
</script>
</html>
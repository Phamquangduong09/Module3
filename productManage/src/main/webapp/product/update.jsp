<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/29/2023
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="width: 600px; margin: auto" action="products?action=update&&id=${product.id}" method="post">
  <input type="text" name="name" placeholder="Enter name" value="${product.name}">
  <input type="text" name="price" placeholder="Enter price" value="${product.price}">
  <select name="brandId">
    <c:forEach var="b" items="${brand}">
      <option value="${b.id}">
          ${b.name}
      </option>
    </c:forEach>
  </select>
  <input type="text" name="color" placeholder="Enter color" value="${product.color}">
  <input type="text" name="describe" placeholder="Enter describe" value="${product.describe}">
  <input type="text" name="date" placeholder="Enter describe" value="${product.date}">
  <button type="submit">Update</button>
  <a href="/home">Back to home</a>
</form>
</body>
</html>

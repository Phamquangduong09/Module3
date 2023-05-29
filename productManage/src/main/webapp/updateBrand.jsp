<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/29/2023
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="width: 600px; margin: auto" action="brand?action=update&&id=${brand.id}" method="post">
    <h2>Form update brand</h2>
    <input type="text" name="name" placeholder="Enter name" value="${brand.name}">
    <button type="submit">Update</button>
    <a href="/brand">Back to home</a>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/31/2023
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">Form create product</h1>
    <form style="width: 600px; margin: auto" action="/product?action=create" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Enter name">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Price</label>
            <input type="text" class="form-control" name="price" id="price" placeholder="Enter price">
        </div>
        <div class="mb-3">
            <label for="brand" class="form-label">Brand</label>
            <select class="form-select" id="brand" name="brand"
                    aria-label="Default select example">
                <c:forEach items="${brand}" var="b">
                    <option value="${b.id}">${b.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Quantity</label>
            <input type="text" class="form-control" name="quantity" id="quantity" placeholder="Enter quantity">
        </div>
        <div class="mb-3">
            <button class="btn btn-primary" type="submit">Create</button>
            <a class="btn btn-secondary" href="/home">Back to home</a>
        </div>
    </form>
</div>
</body>
</html>
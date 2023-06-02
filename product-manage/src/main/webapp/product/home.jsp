<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/30/2023
  Time: 10:01 PM
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
    <h1 style="text-align: center">List Product</h1>
    <div class="row" style="width: 700px; margin: auto">
        <div class="col-lg-4">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/product?action=create">Create
                new classes</a>
        </div>
    </div>
    <div class="row" style="width: 700px; margin: auto">
        <div class="col-lg-4">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/brand">Action Brand</a>
        </div>
    </div>
    <div class="row" style="width: 700px; margin: auto">
        <div class="col-lg-4">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/cart">Cart</a>
        </div>
    </div>
    <table style="width: 700px; margin: auto" class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Brand</th>
            <th>Quantity</th>
            <th colspan="2" style="text-align: center; width: 33%">Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${product}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.brand.name}</td>
                <td>${p.quantity}</td>
                <td>
                    <a class="btn btn-warning" href="/product?action=update&&id=${p.id}">Update</a>
                </td>
                <td>
                    <button class="btn btn-danger" onclick="deleteS(${p.id})">Delete</button>
                </td>
                <td>
                    <button class="btn btn-info" onclick="addToCart(${p.id},${p.quantity})">Add to cart</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script>
    function deleteS(id) {
        if (confirm("Are you sure?")) {
            window.location.href = `http://localhost:8080/product?action=delete&&id=` + id
        }
    }

    function addToCart(id, productQuantity) {
        let quantity = prompt("Enter quantity !!");
        if (quantity > productQuantity) {
            alert("out of stock !!")
        } else if (quantity <= 0) {
            alert("quantity not valid !!")
        } else {
            alert("add success !!");
            window.location.href = "/cart?action=add&id=" + id + "&quantity=" + quantity;
        }
    }
</script>
</script>

</html>

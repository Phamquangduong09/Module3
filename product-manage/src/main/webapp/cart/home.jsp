<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/1/2023
  Time: 10:04 PM
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
    <h1 style="text-align: center">Cart</h1>
    <table style="width: 700px; margin: auto" class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Quantity</th>
            <th>Name</th>
            <th colspan="2" style="text-align: center; width: 33%">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.quantity}</td>
                <td>${c.product.name}</td>
                <td>
                    <button class="btn btn-danger" onclick="deleteS(${c.id})">Delete</button>
                </td>
                <td>
                    <button class="btn btn-danger"onclick="changeQuantity(${c.quantity},${c.id})">Update quantity</button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>${total}</td>
        </tr>
        </tbody>

    </table>
</div>
</body>
<script>
    function changeQuantity(quantity, id) {
        let newQuantity = prompt("Enter quantity !!");
        if (newQuantity <= 0) {
            alert("Invalid quantity !!")
        } else {
            let editQuantity = newQuantity - quantity;
            window.location.href = "/cart?action=updateQuantity&quantity=" + editQuantity + "&id=" + id;
        }
    }
    </script>
</html>

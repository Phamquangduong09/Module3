<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" href="Product.css">
</head>
<body>
<form action="product" method="post">
    <div class="product">
        <h2> Product Description: </h2>
        <input type="text" name="product" size="30" placeholder="Mô tả của sản phẩm"/>
        <h2> List Price: </h2>
        <input type="text" name="price" size="30" placeholder="Giá sản phẩm"/>
        <h2> Discount Percent </h2>
        <input type="text" name="percent" size="30" placeholder="Chiết khấu phần %"/>
        <br>
        <br>
        <input type="submit" value="Calculate"/>
    </div>
</form>
</div>
</body>
</html>
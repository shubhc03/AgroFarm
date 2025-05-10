<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Farmer" %>
<%@ page import="model.Product" %>



<html>
<head>
    <title>Customer Dashboard - Agro Farm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            margin: 0;
        }
        .container {
            width: 90%;
            margin: 20px auto;
        }
        .shop-card {
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            margin-bottom: 30px;
            padding: 20px;
        }
        .shop-header {
            display: flex;
            align-items: center;
        }
        .shop-header img {
            width: 100px;
            height: 100px;
            border-radius: 12px;
            margin-right: 20px;
            object-fit: cover;
        }
        .shop-header h2 {
            margin: 0;
            font-size: 24px;
            color: #333;
        }
        .location {
            font-size: 14px;
            color: gray;
        }
        .products {
            margin-top: 20px;
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
        }
        .product-card {
            background-color: #fafafa;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 10px;
            width: 150px;
            text-align: center;
        }
        .product-card img {
            width: 100%;
            height: 100px;
            object-fit: cover;
            border-radius: 8px;
        }
        .product-name {
            margin-top: 10px;
            font-weight: bold;
            color: #333;
        }
        .product-price {
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <h1>Customer Dashboard</h1>
    <div class="container">

        <%
            List<Farmer> farmers = (List<Farmer>) request.getAttribute("farmers");
            if (farmers != null) {
                for (Farmer farmer : farmers) {
        %>

        <div class="shop-card">
            <div class="shop-header">
                <img src="images/<%= farmer.getShopImage() %>" alt="Shop Image">
                <div>
                    <h2><%= farmer.getName() %>'s Shop</h2>
                    <div class="location"><%= farmer.getLocation() %></div>
                </div>
            </div>

            <div class="products">
                <%
                    List<Product> products = farmer.getProducts();
                    for (Product p : products) {
                %>
                    <div class="product-card">
                        <img src="images/<%= p.getImage() %>" alt="Product Image">
                        <div class="product-name"><%= p.getName() %></div>
                        <div class="product-price">₹<%= p.getPrice() %></div>
                    </div>
                <%
                    }
                %>
            </div>
        </div>

        <%
                }
            } else {
        %>
            <p>No shops available at the moment.</p>
        <%
            }
        %>

    </div>
</body>
</html>

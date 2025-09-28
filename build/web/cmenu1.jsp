<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .product-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }
        .product-card {
            border: 1px solid #ddd;
            padding: 15px;
            width: 250px;
            text-align: center;
            box-shadow: 2px 2px 5px #aaa;
        }
        .buy-button {
            background-color: #28a745;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
        .buy-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>Available Products</h1>
    <div class="product-container">
        <%
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Arpit07", "root", "root");
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM FarmerRegistration");

                while (rs.next()) {
        %>
                    <div class="product-card">
                        <img src="<%= rs.getString("image_url") %>" alt="Product Image" width="150"><br>
                        <h3><%= rs.getString("product_name") %></h3>
                        <p>Price: ₹<%= rs.getDouble("price") %></p>
                        <form action="buyProduct.jsp" method="post">
                            <input type="hidden" name="product_id" value="<%= rs.getInt("id") %>">
                            <button type="submit" class="buy-button">Buy Now</button>
                        </form>
                    </div>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            }
        %>
    </div>
</body>
</html>

<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Orders</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: url('images/farm-bg.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.95);
            max-width: 1000px;
            margin: 60px auto;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.3);
        }

        h1 {
            text-align: center;
            color: #2E8B57;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #2E8B57;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .back-btn {
            display: block;
            margin: 20px auto 0;
            text-align: center;
            background-color: #2E8B57;
            color: white;
            padding: 10px 20px;
            border-radius: 6px;
            text-decoration: none;
            width: 150px;
        }

        .back-btn:hover {
            background-color: #256e45;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>All Orders</h1>
    <table>
        <tr>
            <th>Order ID</th>
            <th>Farmer ID</th>
            <th>Customer ID</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Customer Name</th>
            <th>Order Date</th>
        </tr>
        <%
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
                stmt = con.createStatement();
                int farmer_id=Integer.parseInt(request.getParameter("farmerId"));
                rs = stmt.executeQuery("SELECT * FROM orders where farmer_id="+farmer_id+" ORDER BY order_date DESC");
//                rs = stmt.executeQuery("SELECT * FROM orders ORDER BY order_date DESC");

                while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("order_id") %></td>
            <td><%= rs.getInt("farmer_id") %></td>
            <td><%= rs.getInt("customer_id") %></td>
            <td><%= rs.getInt("product_id") %></td>
            <td><%= rs.getString("product_name") %></td>
            <td><%= rs.getInt("quantity") %></td>
            <td>₹<%= rs.getDouble("price") %></td>
            <td>₹<%= rs.getDouble("total") %></td>
            <td><%= rs.getString("customer_name") %></td>
            <td><%= rs.getTimestamp("order_date") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("<tr><td colspan='10' style='color:red;'>Error: " + e.getMessage() + "</td></tr>");
            } finally {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            }
        %>
    </table>
    <a href="fmenu1.jsp" class="back-btn">Back to Dashboard</a>
</div>
</body>
</html>

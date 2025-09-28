<%@ page import="java.sql.*, java.util.*" %>
<%@ page session="true" %>
<html>
<head>
    <title>Customer Dashboard</title>
    <style>
        body {
            background: #f5f5f5;
            font-family: Arial;
        }
        .shop-card {
            background: white;
            padding: 15px;
            margin: 15px;
            border-radius: 10px;
            box-shadow: 0px 0px 8px rgba(0,0,0,0.1);
        }
        .product {
            margin-left: 20px;
            padding: 10px;
            background: #e7f7e7;
            margin-bottom: 10px;
            border-left: 4px solid green;
        }
    </style>
</head>
<body>
    <h2>Welcome, Customer</h2>
    <h3>Available Farmer Shops:</h3>

<%
    Connection con = null;
    PreparedStatement ps1 = null, ps2 = null;
    ResultSet rs1 = null, rs2 = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishalji?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");

        // Get all farmers
        ps1 = con.prepareStatement("SELECT * FROM FarmerRegistration1");
        rs1 = ps1.executeQuery();

        while (rs1.next()) {
            int farmerId = rs1.getInt("farmer_id");
            String farmerName = rs1.getString("name");
            String location = rs1.getString("location");
%>
    <div class="shop-card">
        <h4><%= farmerName %>'s Shop</h4>
        <p><strong>Location:</strong> <%= location %></p>
        <h5>Products:</h5>
<%
            // Get products of this farmer
            ps2 = con.prepareStatement("SELECT * FROM products1 WHERE farmer_id = ?");
            ps2.setInt(1, farmerId);
            rs2 = ps2.executeQuery();

            while (rs2.next()) {
%>
        <div class="product">
            <strong><%= rs2.getString("name") %></strong> - 
            ?<%= rs2.getDouble("price") %> /unit ? 
            <%= rs2.getString("category") %> |
            Stock: <%= rs2.getInt("stock") %>
        </div>
<%
            }
            rs2.close();
        }
    } catch (Exception e) {
        out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
        e.printStackTrace();
    } finally {
        try { if (rs1 != null) rs1.close(); } catch (Exception e) {}
        try { if (rs2 != null) rs2.close(); } catch (Exception e) {}
        try { if (ps1 != null) ps1.close(); } catch (Exception e) {}
        try { if (ps2 != null) ps2.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%>

</body>
</html>
